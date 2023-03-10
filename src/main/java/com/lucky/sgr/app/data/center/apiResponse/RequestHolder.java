package com.lucky.sgr.app.data.center.apiResponse;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author：LuckySgr.
 * @date: 2023/2/14
 */
public class RequestHolder {

    /**
     * 获取当前线程响应
     */
    public static HttpServletResponse getCurrentResponse() {
        return ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getResponse();
    }

}

