package com.lucky.sgr.app.data.center.menu.service;




import com.lucky.sgr.app.data.center.apiResponse.ApiResponse;
import com.lucky.sgr.app.data.center.menu.domain.dto.pMenuDto.PMenuDTO;
import com.lucky.sgr.app.data.center.menu.domain.entity.pMenu.PMenu;

import java.util.List;
import java.util.Map;

/**
 * @author：LuckySgr.
 * @date: 2023/2/14
 */
public interface MenuService {

    /**
     * 获取菜单树
     * @return
     */
    ApiResponse<?> getMenuTree(String serverType);

    /**
     * 获取菜单列表
     * @param serverType 服务类型
     * @return
     */
    ApiResponse<?> getMenuList(String serverType);

    /**
     * 添加一级目录
     * @param pMenuDTO 一级目录DTO
     * @return
     */
    ApiResponse<?> addParentMenu(PMenuDTO pMenuDTO);

    /**
     * 添加二级目录
     * @param date 前端传参
     * @return
     */
    ApiResponse<?> addSubmenu(Map<String, Object> date);

    /**
     * 查询一级菜单
     * @param serverType 服务类型
     * @return
     */
    ApiResponse<List<PMenu>> queryParentMenu(String serverType);

    /**
     * 根据ID删除目录
     * @param date 前端传参
     * @return
     */
    ApiResponse<?> deleteMenuById(Map<String, Object> date);

    /**
     * 根据ID更新目录启用状态
     * @param date 前端传参
     * @return
     */
    ApiResponse<?> updateMenuById(Map<String, Object> date);

    /**
     * 生成路由
     * @param serverType 服务类型
     * @return
     */
    ApiResponse<?> createRouter(String serverType);

    /**
     * 获取微件列表
     * @param serverType 服务类型
     * @return
     */
    ApiResponse<?> getWidgetsList(String serverType);
}
