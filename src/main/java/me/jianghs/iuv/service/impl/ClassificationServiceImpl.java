package me.jianghs.iuv.service.impl;

import me.jianghs.iuv.entity.Classification;
import me.jianghs.iuv.mapper.ClassificationMapper;
import me.jianghs.iuv.service.IClassificationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
