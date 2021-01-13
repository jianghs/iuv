package me.jianghs.iuv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

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

    /**
     * 定义用户信息服务
     * @return
     */
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("马波").password("123").authorities("p1").build());
        manager.createUser(User.withUsername("牛仔").password("111").authorities("p2").build());
        return manager;
    }

    /**
     * 密码编码器
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * 安全拦截
     * @param http
     * @throws Exception
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
                .loginPage("/loginPage")
                .loginProcessingUrl("/form")
                //成功登陆后跳转页面
                .defaultSuccessUrl("/index")
                .failureUrl("/loginError")
                .permitAll()
                .and();
        http
                // 授权配置
                .authorizeRequests()
                .antMatchers("/resources/r1").hasAuthority("p1")
                .antMatchers("/resources/r2").hasAuthority("p2")
                //无需权限访问
                .antMatchers( "/css/**", "/error404").permitAll()
                .antMatchers("/user/**").hasRole("USER")
                //其他接口需要登录后才能访问
                .anyRequest().authenticated()
                .and();
    }
}
