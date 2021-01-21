package me.jianghs.iuv.common.context;

import me.jianghs.iuv.entity.User;
import me.jianghs.iuv.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserContext {
    @Autowired
    private SpringSecurityContext securityContext;
    @Autowired
    private IUserService userService;

    public User getUserInfo() {
        String username = securityContext.getUserNameFromAuthentication();
        return userService.queryUserByName(username);
    }

    public User getUserInfo(Long id) {
        return userService.getById(id);
    }
}
