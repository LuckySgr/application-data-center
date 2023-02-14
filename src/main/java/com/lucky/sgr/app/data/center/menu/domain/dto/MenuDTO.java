package com.lucky.sgr.app.data.center.menu.domain.dto;

import com.baomidou.mybatisplus.annotation.TableName;

import com.lucky.sgr.app.data.center.menu.domain.entity.sMenu.SMenu;
import lombok.Data;

import java.util.List;

/**
 * @author：LuckySgr.
 * @date: 2023/2/14
 */
@Data
@TableName(value = "p_menu")
public class MenuDTO {
    private String id;
    private String menuName;
    private String menuRoute;
    private String menuIcon;
    private List<SMenu> children;
}
