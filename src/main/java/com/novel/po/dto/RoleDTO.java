package com.novel.po.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/5/25 19:13<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */
@Data
public class RoleDTO {
    @ApiModelProperty("权限密码")
    private String roleName;
    @ApiModelProperty("权限描述")
    private String roleDescription;
}