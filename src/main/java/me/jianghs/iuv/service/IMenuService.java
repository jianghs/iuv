package me.jianghs.iuv.service;

import me.jianghs.iuv.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import me.jianghs.iuv.service.dto.Node;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author jianghs
 * @since 2020-12-30
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 创建根节点列表
     *
     * @param username 用户名
     * @return 根节点列表
     */
    List<Node> createRootNodes(String username);
}
