package com.lucky.sgr.app.data.center.user.service;


import com.lucky.sgr.app.data.center.apiResponse.ApiResponse;
import com.lucky.sgr.app.data.center.user.domain.dto.UserDTO;

/**
 * @author：LuckySgr.
 * @date: 2023/2/14
 */
public interface UserService {
    /**
     * 登录
     */
    ApiResponse<?> login(UserDTO loginDto);
}
