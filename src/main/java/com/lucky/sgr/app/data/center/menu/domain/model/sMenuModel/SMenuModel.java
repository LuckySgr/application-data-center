package com.lucky.sgr.app.data.center.menu.domain.model.sMenuModel;



import com.lucky.sgr.app.data.center.menu.domain.entity.sMenu.SMenu;

import java.util.Map;

/**
 * @author：LuckySgr.
 * @date: 2023/2/14
 * 二级目录领域模型转换类，负责dto跟实体互相转换
 */
public final class SMenuModel {
    /**
     * 静态类方法,不支持new对象
     */
    private SMenuModel() {
    }

    /**
     * SMenuDTO 转化为 SMenu
     *
     * @param date 转换前对象
     * @return 转换后对象
     */
    public static SMenu mapToEntity(Map<String, Object> date) {
        if (date == null) {
            return null;
        }
        SMenu sMenu = new SMenu();
        sMenu.setPId((String) date.get("pMenuName"));
        sMenu.setMenuName((String) date.get("menuName"));
        sMenu.setMenuRoute((String) date.get("menuRoute"));
        sMenu.setMenuIcon((String) date.get("menuIcon"));
        sMenu.setServerType((String) date.get("serverType"));
        Boolean isEnable = (Boolean) date.get("isEnable");
        if (isEnable) {
            sMenu.setIsEnable(1);
        } else {
            sMenu.setIsEnable(0);
        }
        return sMenu;
    }
}
