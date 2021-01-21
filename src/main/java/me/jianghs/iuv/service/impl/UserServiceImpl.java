package me.jianghs.iuv.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import me.jianghs.iuv.common.annotation.RedisCache;
import me.jianghs.iuv.common.exception.BaseException;
import me.jianghs.iuv.entity.Menu;
import me.jianghs.iuv.entity.RoleMenuRelation;
import me.jianghs.iuv.entity.User;
import me.jianghs.iuv.entity.UserRoleRelation;
import me.jianghs.iuv.mapper.UserMapper;
import me.jianghs.iuv.service.IMenuService;
import me.jianghs.iuv.service.IRoleMenuRelationService;
import me.jianghs.iuv.service.IUserRoleRelationService;
import me.jianghs.iuv.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author jianghs
 * @since 2021-01-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;
    @Autowired
    private IUserRoleRelationService userRoleRelationService;
    @Autowired
    private IRoleMenuRelationService roleMenuRelationService;
    @Autowired
    private IMenuService menuService;

    @Override
    @RedisCache(key = "IUV_MENU_LIST", timeOut = 600L)
    public List<Menu> queryMenusByUsername(String username) {
        // 从数据库获取用户信息
        User loginUser = this.queryUserByName(username);

        // 用户查询角色
        LambdaQueryWrapper<UserRoleRelation> userRoleRelationLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userRoleRelationLambdaQueryWrapper.eq(UserRoleRelation::getUserId, loginUser.getId());
        userRoleRelationLambdaQueryWrapper.eq(UserRoleRelation::getStatus, 1);
        List<UserRoleRelation> userRoleRelationList = userRoleRelationService.list(userRoleRelationLambdaQueryWrapper);
        if (CollectionUtils.isEmpty(userRoleRelationList)) {
            return null;
        }

        // 角色查询资源
        List<Long> roleIds = userRoleRelationList.stream().map(UserRoleRelation::getRoleId).collect(Collectors.toList());
        LambdaQueryWrapper<RoleMenuRelation> roleMenuRelationLambdaQueryWrapper = new LambdaQueryWrapper<>();
        roleMenuRelationLambdaQueryWrapper.in(RoleMenuRelation::getRoleId, roleIds);
        roleMenuRelationLambdaQueryWrapper.eq(RoleMenuRelation::getStatus, 1);
        List<RoleMenuRelation> roleMenuRelationList = roleMenuRelationService.list(roleMenuRelationLambdaQueryWrapper);
        if (CollectionUtils.isEmpty(roleMenuRelationList)) {
            return null;
        }
        // 查询所有的菜单
        List<Long> menuIds = roleMenuRelationList.stream().map(RoleMenuRelation::getMenuId).distinct().collect(Collectors.toList());
        LambdaQueryWrapper<Menu> menuLambdaQueryWrapper = new LambdaQueryWrapper<>();
        menuLambdaQueryWrapper.in(Menu::getId, menuIds);
        menuLambdaQueryWrapper.orderByAsc(Menu::getMenuOrder);
        List<Menu> menuList = menuService.list(menuLambdaQueryWrapper);
        if (CollectionUtils.isEmpty(menuList)) {
            return null;
        }
        return menuList;
    }

    @Override
    @RedisCache(key = "IUV_USER", timeOut = 600L)
    public User queryUserByName(String username) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName, username);
        queryWrapper.eq(User::getStatus, 1);
        List<User> users = userMapper.selectList(queryWrapper);
        if (CollectionUtils.isEmpty(users)) {
            return null;
        }
        return users.get(0);
    }
}
