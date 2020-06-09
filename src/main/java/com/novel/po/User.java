package com.novel.po;

import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/5/20 14:26<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */
@Data
public class User extends AbstractFatherPo implements UserDetails  {
    private Long id;
    private String userName;
    private String userPassword;
    private Long userId;
    private Integer start;
    @ToString.Exclude
    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return this.userPassword;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}