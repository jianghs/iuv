package me.jianghs.iuv.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import me.jianghs.iuv.entity.RoleMenuRelation;
import me.jianghs.iuv.entity.User;
import me.jianghs.iuv.entity.UserRoleRelation;
import me.jianghs.iuv.service.IRoleMenuRelationService;
import me.jianghs.iuv.service.IUserRoleRelationService;
import me.jianghs.iuv.service.IUserService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @className: UserDetailServiceImpl
 * @description:
 * @author: jianghs430
 * @createDate: 2021/1/13 15:42
 * @version: 1.0
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    IUserService userService;
    @Autowired
    IUserRoleRelationService userRoleRelationService;
    @Autowired
    IRoleMenuRelationService roleMenuRelationService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从数据库获取用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName, username);
        queryWrapper.eq(User::getStatus, 1);
        List<User> users = userService.list(queryWrapper);
        if (CollectionUtils.isEmpty(users)) {
            throw new UsernameNotFoundException("用户信息查询失败");
        }
        User loginUser = users.get(0);

        // 用户查询角色
        LambdaQueryWrapper<UserRoleRelation> userRoleRelationLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userRoleRelationLambdaQueryWrapper.eq(UserRoleRelation::getUserId, loginUser.getId());
        userRoleRelationLambdaQueryWrapper.eq(UserRoleRelation::getStatus, 1);
        List<UserRoleRelation> userRoleRelationList = userRoleRelationService.list(userRoleRelationLambdaQueryWrapper);
        if (CollectionUtils.isEmpty(userRoleRelationList)) {
            throw new UsernameNotFoundException("角色信息查询失败");
        }

        // 角色查询资源
        List<Long> roleIds = userRoleRelationList.stream().map(UserRoleRelation::getRoleId).collect(Collectors.toList());
        LambdaQueryWrapper<RoleMenuRelation> roleMenuRelationLambdaQueryWrapper = new LambdaQueryWrapper<>();
        roleMenuRelationLambdaQueryWrapper.in(RoleMenuRelation::getRoleId, roleIds);
        roleMenuRelationLambdaQueryWrapper.eq(RoleMenuRelation::getStatus, 1);
        List<RoleMenuRelation> roleMenuRelationList = roleMenuRelationService.list(roleMenuRelationLambdaQueryWrapper);
        if (CollectionUtils.isEmpty(roleMenuRelationList)) {
            throw new UsernameNotFoundException("资源信息查询失败");
        }
        List<Long> menuIds = roleMenuRelationList.stream().map(RoleMenuRelation::getMenuId).distinct().collect(Collectors.toList());
        String[] menuArr = menuIds.stream().map(String::valueOf).toArray(String[]::new);

        return org.springframework.security.core.userdetails.User
                .withUsername(loginUser.getUserName())
                .password(loginUser.getPassword())
                .authorities(menuArr)
                .build();
    }
}
