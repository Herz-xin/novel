package com.novel.until;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/5/21 9:28<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */
public enum ResCode {
    //操作正确
    SUCCESS("200","操作正确"),
    //操作错误
    ERROR("500","操作错误"),
    //权限不足
    AUTHORITY("444","权限不足"),
    //未登录
    LOGIN("433","未登录");

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ResCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
