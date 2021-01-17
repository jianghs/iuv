package me.jianghs.iuv.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import me.jianghs.iuv.common.annotation.RedisCache;
import me.jianghs.iuv.common.exception.BaseException;
import me.jianghs.iuv.entity.Menu;
import me.jianghs.iuv.entity.RoleMenuRelation;
import me.jianghs.iuv.entity.User;
import me.jianghs.iuv.entity.UserRoleRelation;
import me.jianghs.iuv.mapper.MenuMapper;
import me.jianghs.iuv.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.jianghs.iuv.service.IRoleMenuRelationService;
import me.jianghs.iuv.service.IUserRoleRelationService;
import me.jianghs.iuv.service.IUserService;
import me.jianghs.iuv.service.dto.Node;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author jianghs
 * @since 2020-12-30
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    private IUserService userService;

    /**
     * 创建根节点列表
     * @param username 用户名
     * @return 根节点列表
     */
    @Override
    public List<Node> createRootNodes(String username) {
        // 找出所有的菜单
        List<Menu> all = userService.queryMenusByUsername(username);
        // 找出所有根节点
        List<Menu> root = all.stream().filter(menu -> menu.getParentId() == 0).collect(Collectors.toList());

        // 循环根节点组装孩子节点
        return null;
    }
}
