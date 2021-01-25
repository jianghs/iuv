package me.jianghs.iuv.common.context;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import me.jianghs.iuv.entity.Menu;
import me.jianghs.iuv.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.List;

/**
 * @className: MenuContext
 * @description:
 * @author: jianghs430
 * @createDate: 2021/1/25 15:28
 * @version: 1.0
 */
@Component
public class MenuContext {
    @Autowired
    private IMenuService menuService;

    public Model getButtonPermissionsUnderMenu(Model model, long menuId) {
        LambdaQueryWrapper<Menu> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Menu::getParentId, menuId);
        lambdaQueryWrapper.eq(Menu::getMenuType, 3);
        lambdaQueryWrapper.eq(Menu::getStatus, 1);
        return model.addAttribute("buttonPermissions", menuService.list(lambdaQueryWrapper));
    }
}
