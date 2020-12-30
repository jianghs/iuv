package me.jianghs.iuv.service.impl;

import me.jianghs.iuv.entity.LeaveComment;
import me.jianghs.iuv.mapper.LeaveCommentMapper;
import me.jianghs.iuv.service.ILeaveCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 留言表 服务实现类
 * </p>
 *
 * @author jianghs
 * @since 2020-12-30
 */
@Service
public class LeaveCommentServiceImpl extends ServiceImpl<LeaveCommentMapper, LeaveComment> implements ILeaveCommentService {

}
