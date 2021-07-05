package me.jianghs.iuv.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @className: SecurityConfig
 * @description:
 * @author: jianghs430
 * @createDate: 2021/1/12 14:00
 * @version: 1.0
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AppAuthenticationSuccessHandler appAuthenticationSuccessHandler;

    /**
     * 密码编码器
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * 安全拦截
     *
     * @param http httpSecurity
     * @throws Exception 异常
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 关闭csrf防护
                .csrf().disable()
                .headers().frameOptions().disable()
                .and();

        http
                //表单登录
                .formLogin()
                // 自定义登录页面
                .loginPage("/login")
                .loginProcessingUrl("/form")
                //成功登陆后跳转页面
                .defaultSuccessUrl("/index")
                .successHandler(appAuthenticationSuccessHandler)
                .failureUrl("/login?error")
                .permitAll()
                .and();

        http
                // 退出
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .and();

        http
                // web授权配置，具体规则优先
                .authorizeRequests()
//                .antMatchers("/resources/r1").hasAuthority("2")
//                .antMatchers("/resources/r2").hasAuthority("3")
                // 静态文件无需权限访问
                .antMatchers("/css/**", "/fonts/**", "/img/**", "/js/**", "/plugins/**").permitAll()
                .antMatchers("/register").permitAll()
                // 其他接口需要登录后才能访问
                .anyRequest().authenticated()
                .and();

        http
                // 默认是if_required，如果是restapi则需要启用stateless
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
    }
}
