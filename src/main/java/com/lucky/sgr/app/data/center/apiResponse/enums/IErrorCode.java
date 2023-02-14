package com.lucky.sgr.app.data.center.apiResponse.enums;

/**
 * @author：LuckySgr.
 * @date: 2023/2/14
 */
public interface IErrorCode {
    /**
     * 获取异常码
     */
    Integer getCode();

    /**
     * 获取异常描述
     */
    String getMsg();
}
