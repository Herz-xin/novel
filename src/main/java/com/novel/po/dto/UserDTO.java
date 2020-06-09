package com.novel.po.dto;

import com.novel.po.Role;
import io.swagger.annotations.ApiModelProperty;
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
public class UserDTO {
    @ApiModelProperty("账号")
    private String username;
    @ApiModelProperty("密码")
    private String password;
}