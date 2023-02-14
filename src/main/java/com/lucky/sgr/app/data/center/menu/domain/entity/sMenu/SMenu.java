package com.lucky.sgr.app.data.center.menu.domain.entity.sMenu;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author：LuckySgr.
 * @date: 2023/2/14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "s_menu")
public class SMenu implements Serializable {
    private String id;
    private String pId;
    private String menuName;
    private String menuRoute;
    private String menuIcon;
    private String serverType;
    private Integer isEnable;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
