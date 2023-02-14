package com.lucky.sgr.app.data.center.user.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lucky.sgr.app.data.center.apiResponse.ApiResponse;
import com.lucky.sgr.app.data.center.apiResponse.enums.impl.ReturnCode;
import com.lucky.sgr.app.data.center.user.domain.dto.UserDTO;
import com.lucky.sgr.app.data.center.user.domain.entity.User;
import com.lucky.sgr.app.data.center.user.mapper.UserMapper;
import com.lucky.sgr.app.data.center.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author：LuckySgr.
 * @date: 2023/2/14
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ApiResponse<?> login(UserDTO userDto) {
        if (userDto == null) {
            return ApiResponse.fail(ReturnCode.PARAMS_ERROR);
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userDto.getUsername());
        User user = userMapper.selectOne(queryWrapper);
        if (ObjectUtil.isEmpty(user)) {
            return ApiResponse.fail(ReturnCode.USER_IS_NOT);
        } else {
            if (user.getPassword().equals(userDto.getPassword())) {
                return ApiResponse.success(user);
            } else {
                return ApiResponse.fail(ReturnCode.PASSWORD_ERROR);
            }
        }
    }
}
