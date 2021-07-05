package me.jianghs.iuv.service;

import me.jianghs.iuv.entity.Menu;
import me.jianghs.iuv.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author jianghs
 * @since 2021-01-13
 */
public interface IUserService extends IService<User> {
    /**
     * 根据用户名查询用户下所有菜单
     *
     * @param username 用户名
     * @return 菜单列表
     */
    List<Menu> queryMenusByUsername(String username);

    User queryUserByName(String username);
}
