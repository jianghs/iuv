package me.jianghs.iuv.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @className: SecurityConfig
 * @description:
 * @author: jianghs430
 * @createDate: 2021/1/12 14:00
 * @version: 1.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 关闭csrf防护
                .csrf().disable()
                .headers().frameOptions().disable()
                .and();
        http
                //登录处理
                .formLogin()
                // 自定义登录页面
                .loginPage("/loginPage")
                .loginProcessingUrl("/form")
                //成功登陆后跳转页面
                .defaultSuccessUrl("/index")
                .failureUrl("/loginError")
                .permitAll()
                .and();
        http
                .authorizeRequests() // 授权配置
                //无需权限访问
                .antMatchers( "/css/**", "/error404").permitAll()
                .antMatchers("/user/**").hasRole("USER")
                //其他接口需要登录后才能访问
                .anyRequest().authenticated()
                .and();
    }
}
