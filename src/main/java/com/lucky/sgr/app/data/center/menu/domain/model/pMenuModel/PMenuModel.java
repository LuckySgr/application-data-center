package com.lucky.sgr.app.data.center.menu.domain.model.pMenuModel;


import com.lucky.sgr.app.data.center.menu.domain.dto.pMenuDto.PMenuDTO;
import com.lucky.sgr.app.data.center.menu.domain.entity.pMenu.PMenu;

/**
 * @author：LuckySgr.
 * @date: 2023/2/14
 * 一级目录领域模型转换类，负责dto跟实体互相转换
 */
public final class PMenuModel {
    /**
     * 静态类方法,不支持new对象
     */
    private PMenuModel() {
    }

    /**
     * PMenuDTO 转化为 PMenu
     *
     * @param dto 转换前对象
     * @return 转换后对象
     */
    public static PMenu dtoToEntity(PMenuDTO dto) {
        if (dto == null) {
            return null;
        }
        PMenu pMenu = new PMenu();
        pMenu.setMenuName(dto.getMenuName());
        pMenu.setMenuRoute(dto.getMenuRoute());
        pMenu.setMenuIcon(dto.getMenuIcon());
        pMenu.setServerType(dto.getServerType());
        Boolean isEnable = dto.getIsEnable();
        if (isEnable) {
            pMenu.setIsEnable(1);
        } else {
            pMenu.setIsEnable(0);
        }
        return pMenu;
    }
}
