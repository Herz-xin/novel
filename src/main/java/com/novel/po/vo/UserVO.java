package com.novel.po.vo;

import com.novel.po.Role;
import lombok.Data;

import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/5/21 9:18<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */
@Data
public class UserVO {
    private String name;
    private String password;
    private List<Role> roles;
}