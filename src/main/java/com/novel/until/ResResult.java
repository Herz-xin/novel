package com.novel.until;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 后端返回给前端的json格式
 * Description: <br/>
 * date: 2020/5/21 9:19<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */
@Data
public class ResResult<T> {
    @ApiModelProperty(value = "状态码：成功返回200，失败返回500，权限不足返回444，，未登录返回433"
                        ,name = "code")
    private String code;

    @ApiModelProperty(value = "返回信息" , name = "message")
    private String message;

    @ApiModelProperty(value = "返回的数据主体",name = "data")
    private T data;

    /**
     * 默认构造方法
     * 未设值返回成功
     */
    public ResResult() {
        this.code =ResCode.SUCCESS.getCode();
        this.message = ResCode.SUCCESS.getMessage();
    }

    public ResResult(ResCode resCode) {
        this.code = resCode.getCode();
        this.message = resCode.getMessage();
    }

    public ResResult(ResCode resCode, T obj) {
        this.code = resCode.getCode();
        this.message = resCode.getMessage();
        this.data = obj;
    }

    public ResResult(ResCode resCode, String message, T obj) {
        this.code = resCode.getCode();
        this.message = message;
        this.data = obj;
    }

    public static <T> ResResult<T> format(ResCode code) {
        ResResult<T> result = new ResResult<T>(code);
        return result;
    }

    /**
     * 操作失败
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResResult<T> error(String message) {
        ResResult<T> result = new ResResult<>();
        result.setCode(ResCode.ERROR.getCode());
        result.setMessage(message);
        return result;
    }

    /**
     * 操作成功
     * @param <T>
     * @return
     */
    public static <T> ResResult<T> success() {
        ResResult<T> resResult = new ResResult<>();
        return resResult;
    }

    public static <T> ResResult<T> success(T obj) {
        ResResult<T> resResult = new ResResult<>();
        resResult.setData(obj);
        return resResult;
    }

    public static <T> ResResult<T> success(T obj,String message) {
        ResResult<T> resResult = new ResResult<>();
        resResult.setData(obj);
        resResult.setMessage(message);
        return resResult;
    }
}