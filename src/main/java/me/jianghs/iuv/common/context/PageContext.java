package me.jianghs.iuv.common.context;

import me.jianghs.iuv.service.IMenuService;
import me.jianghs.iuv.service.dto.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.List;

@Component
public class PageContext {
    @Autowired
    private SpringSecurityContext securityContext;
    @Autowired
    private IMenuService menuService;

    /**
     * 添加页面公共元素
     * @param model 带入的模型参数
     * @return 返回的模型参数
     */
    public Model addPageCommonElements(Model model) {
        String username = securityContext.getUserNameFromAuthentication();
        model.addAttribute("username", username);
        // 准备菜单列表
        List<Node> nodeList = menuService.createRootNodes(username);
        model.addAttribute("nodeList", nodeList);
        return model;
    }
}
