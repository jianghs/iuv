package me.jianghs.iuv.service.impl;

import me.jianghs.iuv.entity.User;
import me.jianghs.iuv.mapper.UserMapper;
import me.jianghs.iuv.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author jianghs
 * @since 2020-12-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
