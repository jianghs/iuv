package me.jianghs.iuv.service.impl;

import me.jianghs.iuv.entity.Menu;
import me.jianghs.iuv.mapper.MenuMapper;
import me.jianghs.iuv.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.jianghs.iuv.service.dto.Node;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 创建根节点列表
     *
     * @return
     */
    @Override
    public List<Node> createRootNodes() {
        // 找出所有根节点


        // 循环根节点组装孩子节点
        return null;
    }
}
