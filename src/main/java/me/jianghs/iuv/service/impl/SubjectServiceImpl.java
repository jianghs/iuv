package me.jianghs.iuv.service.impl;

import me.jianghs.iuv.entity.Subject;
import me.jianghs.iuv.mapper.SubjectMapper;
import me.jianghs.iuv.service.ISubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 专题表 服务实现类
 * </p>
 *
 * @author jianghs
 * @since 2020-12-30
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements ISubjectService {

}
