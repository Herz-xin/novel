package com.novel.config;

import com.novel.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;

/**
 * @EnableWebFluxSecurity 开启注解会导致一个Bug<br>
 *     authenticationManager cannot be null
 * Description: <br/>
 * date: 2020/5/21 13:27<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter  {

    @Autowired
    LoginUserService loginUserService;

    @Override
    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    /**
     * springsecurity内置的加密方式
     * @return
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

                //设置允许访问页
                .antMatchers("/")
                //依然会经过后续所有的认证
                .permitAll()
                //其他地址需要认证
                .anyRequest().authenticated()

                //配置登录信息
                //and是连接符
                /*.and()
                //修改登录页，不修改默认使用Security的登录页
                .formLogin()
                //修改后的登录页地址。
                .loginPage("/Login")
                //指定处理器地址
                .loginProcessingUrl("/Login")
                //指定默认跳转地址
                .defaultSuccessUrl("/login/User")
                //指定账号和密码的值name值
                .usernameParameter("root")
                .passwordParameter("123456")*/

                //配置登出信息
                .and()
                .logout()
                //退出地址
                .logoutUrl("/logout")
                //退出成功页面
                .logoutSuccessUrl("/logout")

                /*//配置CSRF拦截
                .and()
                .csrf()
                .disable()*/

//                .and()
//                .authenticationProvider()



        ;


    }

    /**
     * 配置认证用户的来源
     * 有内存和数据库两种形式
     * @param auth
     * @throws Exception
     */
    @Override
//    @Bean
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.
                //使用内存的方法
                inMemoryAuthentication().
                //用户名
                withUser("root").
                //密码
                password("123456")
                .roles("User");

//                userDetailsService(loginUserService)
//                .passwordEncoder(bCryptPasswordEncoder());
    }

    @Bean
    public UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter() throws Exception {
        UsernamePasswordAuthenticationFilter u = new UsernamePasswordAuthenticationFilter();
        u.setAuthenticationManager(authenticationManagerBean());
        return u;
    }
}