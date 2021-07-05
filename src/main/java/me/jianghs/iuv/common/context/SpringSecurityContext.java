package me.jianghs.iuv.common.context;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @className: SecurityContext
 * @description:
 * @author: jianghs430
 * @createDate: 2021/1/18 14:54
 * @version: 1.0
 */
@Component
public class SpringSecurityContext {
    /**
     * 从授权信息中获取用户名
     *
     * @return 用户名
     */
    public String getUserNameFromAuthentication() {
        String username;
        // 当前认证通过的用户身份
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (Objects.isNull(principal)) {
            username = "匿名";
        } else if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            username = userDetails.getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }
}
