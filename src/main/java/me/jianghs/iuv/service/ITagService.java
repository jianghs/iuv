package me.jianghs.iuv.service;

import me.jianghs.iuv.entity.Tag;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 标签表 服务类
 * </p>
 *
 * @author jianghs
 * @since 2020-12-30
 */
public interface ITagService extends IService<Tag> {

    /**
     * 详情
     * @param id 主键
     * @return 根据主键返回的结果
     */
    Tag detail(long id);

    /**
     * 新增
     * @param tag 入参
     * @return 出参
     */
    Tag addTag(Tag tag);

    /**
     * 更新
     * @param tag
     * @return 更新
     */
    Tag updateTag(Tag tag);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);
}
