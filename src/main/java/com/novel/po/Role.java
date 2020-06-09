package com.novel.po;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/5/25 19:16<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */
@Data
public class Role extends AbstractFatherPo implements GrantedAuthority {
    private Integer id;
    private String roleName;
    private String roleDescription;
    private Integer roleId;

    @Override
    public String getAuthority() {
        return roleName;
    }
}