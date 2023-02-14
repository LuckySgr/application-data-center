package com.lucky.sgr.app.data.center.menu.controller;



import com.lucky.sgr.app.data.center.apiResponse.ApiResponse;
import com.lucky.sgr.app.data.center.menu.domain.dto.pMenuDto.PMenuDTO;
import com.lucky.sgr.app.data.center.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author：LuckySgr.
 * @date: 2023/2/14
 */
@RestController
@CrossOrigin // 允许跨域
@RequestMapping("/api/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    /**
     * 获取目录树
     *
     * @param serverType 服务类型
     * @return
     */
    @GetMapping("/getMenuTree")
    public ApiResponse<?> getMenuTree(String serverType) {
        return menuService.getMenuTree(serverType);
    }

    /**
     * 获取目录列表
     *
     * @param serverType 服务类型
     * @return
     */
    @GetMapping("/getMenuList")
    public ApiResponse<?> getMenuList(String serverType) {
        return menuService.getMenuList(serverType);
    }

    /**
     * 添加一级目录
     *
     * @param pMenuDTO 一级目录DTO
     * @return
     */
    @PostMapping("/addParentMenu")
    public ApiResponse<?> addParentMenu(@RequestBody(required = false) PMenuDTO pMenuDTO) {
        return menuService.addParentMenu(pMenuDTO);
    }

    /**
     * 添加二级目录
     *
     * @param date 前端传参
     * @return
     */
    @PostMapping("/addSubmenu")
    public ApiResponse<?> addSubmenu(@RequestBody(required = false) Map<String, Object> date) {
        return menuService.addSubmenu(date);
    }

    /**
     * 查询一级目录
     *
     * @param serverType 服务类型
     * @return
     */
    @GetMapping("/queryParentMenu")
    public ApiResponse<?> queryParentMenu(String serverType) {
        return menuService.queryParentMenu(serverType);
    }

    /**
     * 根据ID删除目录
     *
     * @param date 前端传参
     * @return
     */
    @PostMapping("/deleteMenuById")
    public ApiResponse<?> deleteMenuById(@RequestBody(required = false) Map<String, Object> date) {
        return menuService.deleteMenuById(date);
    }

    /**
     * 根据ID更新目录启用状态
     *
     * @param date 前端传参
     * @return
     */
    @PostMapping("/updateMenuById")
    public ApiResponse<?> updateMenuById(@RequestBody(required = false) Map<String, Object> date) {
        return menuService.updateMenuById(date);
    }

    /**
     * 生成路由
     *
     * @param serverType 服务类型
     * @return
     */
    @GetMapping("/createRouter")
    public ApiResponse<?> createRouter(String serverType) {
        return menuService.createRouter(serverType);
    }

    /**
     * 获取微件列表
     *
     * @param serverType 服务类型
     * @return
     */
    @GetMapping("/getWidgetsList")
    public ApiResponse<?> getWidgetsList(String serverType) {
        return menuService.getWidgetsList(serverType);
    }
}

