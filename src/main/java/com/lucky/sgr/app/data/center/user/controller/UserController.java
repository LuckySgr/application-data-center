package com.lucky.sgr.app.data.center.user.controller;


import com.lucky.sgr.app.data.center.apiResponse.ApiResponse;
import com.lucky.sgr.app.data.center.user.domain.dto.UserDTO;
import com.lucky.sgr.app.data.center.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author：LuckySgr.
 * @date: 2023/2/14
 */
@RestController
@CrossOrigin // 允许跨域
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ApiResponse<?> login(@RequestBody(required = false) UserDTO userDto) {
        return userService.login(userDto);
    }
}
