package com.lucky.sgr.app.data.center.menu.domain.dto.sMenuDto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author：LuckySgr.
 * @date: 2023/2/14
 */
@Data
public class SMenuDTO implements Serializable {
    private String id;
    private String pMenuName;
    private String menuName;
    private String menuRoute;
    private String menuIcon;
    private String serverType;
    private Boolean isEnable;
    private Date createTime;
    private Date updateTime;
}
