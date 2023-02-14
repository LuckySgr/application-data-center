package com.lucky.sgr.app.data.center.user.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author：LuckySgr.
 * @date: 2023/2/14
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User implements Serializable {
    private String id;
    private String username;
    private String password;
    private String sex;
    private String status;
    private Date registerTime;
}
