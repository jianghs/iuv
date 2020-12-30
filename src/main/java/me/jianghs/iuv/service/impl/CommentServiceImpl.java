package me.jianghs.iuv.service.impl;

import me.jianghs.iuv.entity.Comment;
import me.jianghs.iuv.mapper.CommentMapper;
import me.jianghs.iuv.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author jianghs
 * @since 2020-12-30
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
