package me.jianghs.iuv.service.impl;

import me.jianghs.iuv.entity.Role;
import me.jianghs.iuv.mapper.RoleMapper;
import me.jianghs.iuv.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author jianghs
 * @since 2020-12-30
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
