package com.novel.service.serviceimpl;

import com.novel.mapper.UserMapper;
import com.novel.po.Role;
import com.novel.po.vo.UserVO;
import com.novel.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 登录实现类
 * Description: <br/>
 * date: 2020/5/25 18:30<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */
@Service
public class LoginUserServiceImpl implements LoginUserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    AuthenticationManager authenticationManager;

    /**
     * 这是SpringSecurity的认证业务
     * 返回null代表认证失败
     * @param name
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        UserVO selectByName = userMapper.getSelectByName(name);
        if (name == "" || name == null || selectByName == null) {
            throw new UsernameNotFoundException(" username 或者 password无效");
        }
        //赋值角色
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role r : selectByName.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
        }
        return new User(name,selectByName.getPassword(),authorities);
    }
}