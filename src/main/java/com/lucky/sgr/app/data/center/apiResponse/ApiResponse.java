package com.lucky.sgr.app.data.center.apiResponse;

import com.lucky.sgr.app.data.center.apiResponse.enums.impl.ReturnCode;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author：LuckySgr.
 * @date: 2023/2/14
 */
@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ApiResponse<T> implements Serializable {


    /**
     * 响应编码
     */
    private int code;
    /**
     * 响应结果描述
     */
    private String message;
    /**
     * 业务数据
     */
    private T data;


    /*
     * 无业务数据的成功响应
     * @return
     */
    public static<T> ApiResponse<T> success() {
        return success(null);
    }

    /**
     * 带业务数据的成功响应
     */
    public static <T> ApiResponse<T> success(T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode(ReturnCode.SUCCESS.getCode());
        response.setMessage(ReturnCode.SUCCESS.getMsg());
        response.setData(data);
        return response;
    }

    /**
     * 响应失败
     */
    public static<T> ApiResponse<T> fail() {
        return fail(ReturnCode.FAIL.getCode(), ReturnCode.FAIL.getMsg());
    }


    /**
     * 响应失败
     */
    public static<T> ApiResponse<T> fail(ReturnCode responseCode) {
        return fail(responseCode.getCode(), responseCode.getMsg());
    }

    /**
     * 响应失败
     */
    public static<T> ApiResponse<T> fail(int failCode, String msg, T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode(failCode);
        response.setMessage(msg);
        response.setData(data);
        //设置响应头
        HttpServletResponse currentResponse = RequestHolder.getCurrentResponse();
        currentResponse.setStatus(getResponseStatus(failCode));
        return response;
    }

    /**
     * 响应失败
     */
    public static<T> ApiResponse<T> fail(int failCode, String msg) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode(failCode);
        response.setMessage(msg);
        //设置响应头
        HttpServletResponse currentResponse = RequestHolder.getCurrentResponse();
        currentResponse.setStatus(getResponseStatus(failCode));
        return response;
    }

    private static Integer getResponseStatus(int failCode) {
        if (failCode == ReturnCode.FAIL.getCode() || failCode == ReturnCode.SYSTEM_ERROR.getCode()) {
            return HttpStatus.INTERNAL_SERVER_ERROR.value();
        } else if (failCode == ReturnCode.PARAMS_ERROR.getCode()) {
            return HttpStatus.BAD_REQUEST.value();
        } else if (failCode == ReturnCode.SIGN_ERROR.getCode()) {
            return HttpStatus.UNAUTHORIZED.value();
        } else {
            return HttpStatus.OK.value();
        }
    }
}

