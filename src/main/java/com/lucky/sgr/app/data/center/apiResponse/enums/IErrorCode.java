package com.lucky.sgr.app.data.center.apiResponse.enums;

/**
 * @author：LuckySgr.
 * @date: 2021/12/19
 */
public interface IErrorCode {
    /**
     * 获取异常码
     *
     * @return
     */
    Integer getCode();

    /**
     * 获取异常描述
     *
     * @return
     */
    String getMsg();
}
