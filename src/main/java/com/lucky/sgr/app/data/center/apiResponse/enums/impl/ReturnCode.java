package com.lucky.sgr.app.data.center.apiResponse.enums.impl;


import com.lucky.sgr.app.data.center.apiResponse.enums.IErrorCode;

/**
 * @author：LuckySgr.
 * @date: 2021/12/19
 */
public enum ReturnCode implements IErrorCode {

    /**
     * 请求成功
     */
    SUCCESS(200, "SUCCESS"),
    /**
     * 请求失败
     */
    FAIL(201, "ERROR"),
    /**
     * 参数不合法
     */
    PARAMS_ERROR(202, "参数不合法"),
    /**
     * 验证失败
     */
    SIGN_ERROR(203, "验证失败"),
    /**
     * 系统异常
     */
    SYSTEM_ERROR(204, "系统异常"),
    /**
     * 用户不存在
     */
    USER_IS_NOT(205, "用户不存在"),
    /**
     * 密码错误
     */
    PASSWORD_ERROR(206, "密码错误");

    private final Integer code;
    private final String msg;


    ReturnCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public Integer getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }
}

