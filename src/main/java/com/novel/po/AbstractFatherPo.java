package com.novel.po;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 所有po类的父类
 * <p>
 *     所有po类的父类
 * </p>
 * Description: <br/>
 * date: 2020/5/15 20:18<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */
public abstract class AbstractFatherPo implements Serializable {

    /**
     * 这个尽量不要动
     */
    private static  final long serialVersionUID = 1L;

    /**
     * 创建时间
     */
    @NotNull(message = "创建时间不能为空")
    private LocalDateTime createDate = LocalDateTime.now();

    /**
     * 修改时间
     */
    private LocalDateTime modifyDate = LocalDateTime.now();

    /**
     * 创建人
     */
    @NotNull(message = "创建人不能为空")
    private String createBy;

    /**
     * 修改人
     */
    private String modifyBy;

    /**
     * 状态码
     */
    private Integer start;
}