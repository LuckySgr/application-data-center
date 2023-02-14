package com.lucky.sgr.app.data.center.user.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author：LuckySgr.
 * @date: 2023/2/14
 */
@Setter
@Getter
public class UserDTO implements Serializable {
    private String username;
    private String password;
}
