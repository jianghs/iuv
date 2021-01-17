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
import me.jianghs.iuv.service.converter.MenuConverter;
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
        List<Node> allNodes = MenuConverter.INSTANCE.sourceToTarget(all);
        // 找出所有根节点
        List<Node> roots = allNodes.stream().filter(node -> node.getParentId() == 0).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(roots)) {
            return null;
        }
        // 循环根节点组装孩子节点
        for (Node node : roots) {
            node.setChildren(this.queryChildren(node, allNodes));
        }
        return roots;
    }

    /**
     * 递归查询所有孩子节点
     * @param node 当前节点
     * @param allNodes 所有节点列表
     * @return 孩子节点
     */
    private List<Node> queryChildren(Node node, List<Node> allNodes) {
        // 根据当前节点id查询孩子节点
        List<Node> children = allNodes.stream().filter(x -> x.getParentId().equals(node.getId())).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(children)) {
            return null;
        }
        for (Node child : children) {
            child.setChildren(this.queryChildren(child, allNodes));
        }
        return children;
    }
}
