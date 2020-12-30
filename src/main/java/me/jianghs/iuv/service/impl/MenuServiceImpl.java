package me.jianghs.iuv.service.impl;

import me.jianghs.iuv.entity.Menu;
import me.jianghs.iuv.mapper.MenuMapper;
import me.jianghs.iuv.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
