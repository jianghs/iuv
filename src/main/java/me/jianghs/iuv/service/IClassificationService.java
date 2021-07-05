package me.jianghs.iuv.service;

import me.jianghs.iuv.entity.Classification;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 分类表 服务类
 * </p>
 *
 * @author jianghs
 * @since 2020-12-30
 */
public interface IClassificationService extends IService<Classification> {

    /**
     * 删除
     *
     * @param id 主键
     */
    void delete(Long id);

    /**
     * 新增
     *
     * @param classification
     */
    void addClassification(Classification classification);

    /**
     * 编辑
     *
     * @param classification
     */
    void updateClassification(Classification classification);
}
