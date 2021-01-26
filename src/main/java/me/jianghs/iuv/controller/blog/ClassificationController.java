package me.jianghs.iuv.controller.blog;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import me.jianghs.iuv.common.context.MenuContext;
import me.jianghs.iuv.common.context.PageContext;
import me.jianghs.iuv.common.context.UserContext;
import me.jianghs.iuv.common.page.PageResult;
import me.jianghs.iuv.controller.blog.command.ClassificationCommand;
import me.jianghs.iuv.controller.blog.converter.ClassificationPageConverter;
import me.jianghs.iuv.controller.blog.query.ClassificationPageQuery;
import me.jianghs.iuv.controller.blog.query.ClassificationQuery;
import me.jianghs.iuv.controller.blog.query.TagQuery;
import me.jianghs.iuv.controller.blog.result.ClassificationPage;
import me.jianghs.iuv.entity.Classification;
import me.jianghs.iuv.entity.User;
import me.jianghs.iuv.service.IClassificationService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @className: ClassificationController
 * @description:
 * @author: jianghs430
 * @createDate: 2021/1/26 9:24
 * @version: 1.0
 */

@Slf4j
@Controller
@RequestMapping("/blog/classification")
public class ClassificationController {
    @Autowired
    private PageContext pageContext;
    @Autowired
    private UserContext userContext;
    @Autowired
    private MenuContext menuContext;
    @Autowired
    private IClassificationService classificationService;
    /**
     * 分类页面
     */
    @PreAuthorize("hasAuthority('classification_management')")
    @RequestMapping("")
    public String classification(Model model, @ModelAttribute(value = "classificationQuery")ClassificationQuery query) {
        pageContext.addPageCommonElements(model);
        return "/blog/classification";
    }

    /**
     * 查询页面
     */
    @PreAuthorize("hasAuthority('classification_query')")
    @RequestMapping("/query")
    public String query(Model model, @ModelAttribute(value = "classificationQuery") ClassificationQuery query) {
        pageContext.addPageCommonElements(model);
        return "/blog/classification";
    }

    /**
     * 新增页面
     */
    @PreAuthorize("hasAuthority('classification_add')")
    @RequestMapping("/add")
    public String add(Model model, @ModelAttribute(value = "classificationCommand") ClassificationCommand classificationCommand) {
        pageContext.addPageCommonElements(model);

        Classification classification = new Classification();
        classification.setClassificationName(classificationCommand.getClassificationName());
        classification.setIntroduction(classificationCommand.getIntroduction());
        classification.setClassificationOrder(classificationCommand.getClassificationOrder());
        classification.setPriority(classificationCommand.getPriority());
        classification.setCreatorId(userContext.getUserInfo().getId());
        try {
            classificationService.addClassification(classification);
        } catch (Exception e) {
            model.addAttribute("errorInfo", e.getMessage());
        }
        model.addAttribute("classificationQuery", new ClassificationQuery());
        return "blog/classification";
    }

    /**
     * 编辑页面
     */
    @PreAuthorize("hasAuthority('classification_edit')")
    @RequestMapping("/edit")
    public String edit(Model model, @ModelAttribute(value = "classificationCommand") ClassificationCommand classificationCommand) {
        pageContext.addPageCommonElements(model);

        Classification classification = new Classification();
        classification.setId(classificationCommand.getId());
        classification.setClassificationName(classificationCommand.getClassificationName());
        classification.setIntroduction(classificationCommand.getIntroduction());
        classification.setClassificationOrder(classificationCommand.getClassificationOrder());
        classification.setPriority(classificationCommand.getPriority());
        classification.setClassificationStatus(classificationCommand.getClassificationStatus());
        classification.setModifierId(userContext.getUserInfo().getId());
        try {
            classificationService.updateClassification(classification);
        } catch (Exception e) {
            model.addAttribute("errorInfo", e.getMessage());
        }
        model.addAttribute("classificationQuery", new ClassificationQuery());
        return "blog/classification";
    }

    /**
     * 删除页面
     */
    @PreAuthorize("hasAuthority('classification_delete')")
    @RequestMapping("/delete")
    public String add(Model model, @ModelAttribute(value = "id") Long id) {
        pageContext.addPageCommonElements(model);

        try {
            classificationService.delete(id);
        } catch (Exception e) {
            model.addAttribute("errorInfo", e.getMessage());
        }
        model.addAttribute("tagQuery", new TagQuery());
        return "blog/classification";
    }


    /**
     * 分页
     * @param classificationPageQuery
     * @return
     */
    @PostMapping("/page")
    @ResponseBody
    public PageResult<ClassificationPage> page(@RequestBody @Valid ClassificationPageQuery classificationPageQuery) {
        log.info("请求：{}", classificationPageQuery);
        if (classificationPageQuery.getClassificationStatus() == 0) {
            classificationPageQuery.setClassificationStatus(null);
        }
        LocalDateTime start = null;
        LocalDateTime end = null;

        if (StringUtils.isNotBlank(classificationPageQuery.getDateRange())) {
            String[] dates = classificationPageQuery.getDateRange().split("~");
            start = LocalDateTime.parse(dates[0].trim() +" 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            end = LocalDateTime.parse(dates[1].trim() +" 23:59:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }

        Page<Classification> page = new Page<>(classificationPageQuery.getCurrent(), classificationPageQuery.getSize());
        LambdaQueryWrapper<Classification> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(classificationPageQuery.getClassificationName()), Classification::getClassificationName, classificationPageQuery.getClassificationName());
        queryWrapper.eq(Objects.nonNull(classificationPageQuery.getClassificationStatus()), Classification::getClassificationStatus, classificationPageQuery.getClassificationStatus());
        // 大于等于 开始时间
        queryWrapper.ge(Objects.nonNull(start), Classification::getCreateTime, start);
        // 小于等于 结束时间
        queryWrapper.le(Objects.nonNull(end), Classification::getCreateTime, end);
        queryWrapper.orderByDesc(Classification::getId);
        Page<Classification> classificationPage = classificationService.page(page, queryWrapper);
        PageResult<ClassificationPage> pageResult = ClassificationPageConverter.INSTANCE.pageCopy(classificationPage);

        if (CollectionUtils.isNotEmpty(pageResult.getRecords())) {
            pageResult.getRecords().stream().map(x -> {
                User user = userContext.getUserInfo(x.getCreatorId());
                x.setCreator(Objects.nonNull(user) ? user.getUserName() : "");
                return x;
            }).collect(Collectors.toList());
        }
        log.info("返回：{}", pageResult);
        return pageResult;
    }
}
