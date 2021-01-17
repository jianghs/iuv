package me.jianghs.iuv.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import me.jianghs.iuv.entity.Menu;
import me.jianghs.iuv.entity.RoleMenuRelation;
import me.jianghs.iuv.entity.User;
import me.jianghs.iuv.entity.UserRoleRelation;
import me.jianghs.iuv.service.IMenuService;
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
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从数据库获取用户信息
        User loginUser = userService.queryUserByName(username);

        List<Menu> menuList = userService.queryMenusByUsername(username);
        List<String> menuCodeList = menuList.stream().map(Menu::getMenuCode).distinct().collect(Collectors.toList());
        String[] menuArr = menuCodeList.toArray(new String[menuCodeList.size()]);

        return org.springframework.security.core.userdetails.User
                .withUsername(loginUser.getUserName())
                .password(loginUser.getPassword())
                .authorities(menuArr)
                .build();
    }
}
