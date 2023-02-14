package com.lucky.sgr.app.data.center.menu.domain.dto.pMenuDto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author：LuckySgr.
 * @date: 2023/2/14
 */
@Data
public class PMenuDTO implements Serializable {
    private String id;
    private String menuName;
    private String menuRoute;
    private String menuIcon;
    private String serverType;
    private Boolean isEnable;
    private Date createTime;
    private Date updateTime;
}
