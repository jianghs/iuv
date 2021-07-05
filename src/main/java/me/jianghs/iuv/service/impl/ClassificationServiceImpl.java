package me.jianghs.iuv.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import me.jianghs.iuv.common.exception.BaseException;
import me.jianghs.iuv.entity.Classification;
import me.jianghs.iuv.entity.Tag;
import me.jianghs.iuv.mapper.ClassificationMapper;
import me.jianghs.iuv.mapper.TagMapper;
import me.jianghs.iuv.service.IClassificationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 分类表 服务实现类
 * </p>
 *
 * @author jianghs
 * @since 2020-12-30
 */
@Service
public class ClassificationServiceImpl extends ServiceImpl<ClassificationMapper, Classification> implements IClassificationService {
    @Resource
    private ClassificationMapper classificationMapper;

    /**
     * 删除
     *
     * @param id 主键
     */
    @Override
    public void delete(Long id) {
        classificationMapper.deleteById(id);
    }

    /**
     * 新增
     *
     * @param classification
     */
    @Override
    public void addClassification(Classification classification) {
        LambdaQueryWrapper<Classification> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Classification::getClassificationName, classification.getClassificationName());
        List<Classification> exists = classificationMapper.selectList(queryWrapper);
        if (CollectionUtils.isNotEmpty(exists)) {
            throw new BaseException("分类已存在！");
        }
        classification.setClassificationStatus(1);
        classification.setCreateTime(LocalDateTime.now());
        classificationMapper.insert(classification);
    }

    /**
     * 编辑
     *
     * @param classification
     */
    @Override
    public void updateClassification(Classification classification) {
        classification.setModifyTime(LocalDateTime.now());
        classificationMapper.updateById(classification);
    }
}
