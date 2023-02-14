package com.lucky.sgr.app.data.center.menu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lucky.sgr.app.data.center.apiResponse.ApiResponse;
import com.lucky.sgr.app.data.center.menu.domain.dto.MenuDTO;
import com.lucky.sgr.app.data.center.menu.domain.dto.pMenuDto.PMenuDTO;
import com.lucky.sgr.app.data.center.menu.domain.dto.sMenuDto.SMenuDTO;
import com.lucky.sgr.app.data.center.menu.domain.entity.pMenu.PMenu;
import com.lucky.sgr.app.data.center.menu.domain.entity.sMenu.SMenu;
import com.lucky.sgr.app.data.center.menu.domain.model.pMenuModel.PMenuModel;
import com.lucky.sgr.app.data.center.menu.domain.model.sMenuModel.SMenuModel;
import com.lucky.sgr.app.data.center.menu.mapper.MenuMapper;
import com.lucky.sgr.app.data.center.menu.mapper.pMenuMapper.PMenuMapper;
import com.lucky.sgr.app.data.center.menu.mapper.sMenuMapper.SMenuMapper;
import com.lucky.sgr.app.data.center.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author：LuckySgr.
 * @date: 2023/2/14
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private PMenuMapper pMenuMapper;
    @Autowired
    private SMenuMapper sMenuMapper;

    /**
     * 获取目录树
     *
     * @param serverType 服务类型
     * @return
     */
    @Override
    public ApiResponse<?> getMenuTree(String serverType) {
        QueryWrapper<MenuDTO> menuQueryWrapper = new QueryWrapper<>();
        menuQueryWrapper
                .select("id", "menu_name", "menu_route", "menu_icon")
                .eq("is_enable", 1)
                .eq("server_type", serverType);
        List<MenuDTO> menu = menuMapper.selectList(menuQueryWrapper);
        QueryWrapper<SMenu> sMenuQueryWrapper = new QueryWrapper<>();
        sMenuQueryWrapper
                .select("id", "p_id", "menu_name", "menu_route", "menu_icon")
                .eq("is_enable", 1)
                .eq("server_type", serverType);
        List<SMenu> sMenus = sMenuMapper.selectList(sMenuQueryWrapper);
        // 获取根节点
        List<MenuDTO> collect = menu.stream().peek(m -> m.setChildren(getChildren(m, sMenus))).collect(Collectors.toList());
        return ApiResponse.success(collect);
    }

    /**
     * 查询子节点
     *
     * @param root 根节点
     * @param all  所有节点
     * @return 根节点信息
     */
    private List<SMenu> getChildren(MenuDTO root, List<SMenu> all) {
        return all.stream().filter(m -> Objects.equals(m.getPId(), root.getId())).peek(
                m -> {
                    List<SMenu> sMenus = new ArrayList<>();
                    sMenus.add(m);
                    root.setChildren(sMenus);
                }
        ).collect(Collectors.toList());
    }

    /**
     * 获取目录列表
     *
     * @param serverType 服务类型
     * @return
     */
    @Override
    public ApiResponse<?> getMenuList(String serverType) {
        QueryWrapper<PMenu> pMenuQueryWrapper = new QueryWrapper<>();
        pMenuQueryWrapper.select("id", "menu_name", "is_enable").eq("server_type", serverType);
        List<PMenu> pMenus = pMenuMapper.selectList(pMenuQueryWrapper);
        List<SMenuDTO> sMenuInfo = sMenuMapper.getSMenuInfo(serverType);
        List<Object> arrayList = new ArrayList<>();
        arrayList.add(pMenus);
        arrayList.add(sMenuInfo);
        return ApiResponse.success(arrayList);
    }

    /**
     * 添加一级目录
     *
     * @param pMenuDTO 一级目录DTO
     * @return
     */
    @Override
    public ApiResponse<?> addParentMenu(PMenuDTO pMenuDTO) {
        PMenu pMenu = PMenuModel.dtoToEntity(pMenuDTO);
        int insert = pMenuMapper.insert(pMenu);
        if (insert != 1) return ApiResponse.fail();
        return ApiResponse.success();
    }

    /**
     * 添加二级目录
     *
     * @param date 前端传参
     * @return
     */
    @Override
    public ApiResponse<?> addSubmenu(Map<String, Object> date) {
        SMenu sMenu = SMenuModel.mapToEntity(date);
        int insert = sMenuMapper.insert(sMenu);
        if (insert != 1) return ApiResponse.fail();
        return ApiResponse.success();
    }

    /**
     * 查询一级目录
     *
     * @param serverType 服务类型
     * @return
     */
    @Override
    public ApiResponse<List<PMenu>> queryParentMenu(String serverType) {
        QueryWrapper<PMenu> pMenuQueryWrapper = new QueryWrapper<>();
        pMenuQueryWrapper.select("id", "menu_name").eq("server_type", serverType);
        List<PMenu> pMenus = pMenuMapper.selectList(pMenuQueryWrapper);
        return ApiResponse.success(pMenus);
    }

    /**
     * 根据ID删除目录
     *
     * @param date 前端传参
     * @return
     */
    @Override
    public ApiResponse<?> deleteMenuById(Map<String, Object> date) {
        Object pMenuName = date.get("pmenuName");
        QueryWrapper<SMenu> sMenuQueryWrapper = new QueryWrapper<>();
        if ("无".equals(pMenuName)) {
            int id1 = pMenuMapper.deleteById((Serializable) date.get("id"));
            if (id1 != 1) return ApiResponse.fail();
            sMenuQueryWrapper.select("id").eq("p_id", date.get("id"));
            List<SMenu> sMenus = sMenuMapper.selectList(sMenuQueryWrapper);
            if (sMenus.size() > 0) {
                int id2 = sMenuMapper.deleteBatchIds(sMenus);
                if (id2 != 1) return ApiResponse.fail();
            }
            return ApiResponse.success();
        } else {
            int id = sMenuMapper.deleteById((Serializable) date.get("id"));
            if (id != 1) return ApiResponse.fail();
            return ApiResponse.success();
        }
    }

    /**
     * 根据ID更新目录启用状态
     *
     * @param date 前端传参
     * @return
     */
    @Override
    public ApiResponse<?> updateMenuById(Map<String, Object> date) {
        Object pMenuName = date.get("pmenuName");
        Boolean isEnable = (Boolean) date.get("isEnable");
        int enable = 0;
        if (isEnable) {
            enable = 1;
        }
        QueryWrapper<SMenu> sMenuQueryWrapper = new QueryWrapper<>();
        if ("无".equals(pMenuName)) {
            int id1 = pMenuMapper.updateById(enable, (String) date.get("id"));
            if (id1 != 1) return ApiResponse.fail();
            sMenuQueryWrapper.select("id").eq("p_id", date.get("id"));
            List<SMenu> sMenus = sMenuMapper.selectList(sMenuQueryWrapper);
            if (sMenus.size() > 0) {
                for (SMenu sMenu : sMenus) {
                    int i = sMenuMapper.updateById(enable, sMenu.getId());
                    if (i != 1) return ApiResponse.fail();
                }
            }
            return ApiResponse.success();
        } else {
            int i = sMenuMapper.updateById(enable, (String) date.get("id"));
            if (i != 1) return ApiResponse.fail();
            return ApiResponse.success();
        }
    }

    /**
     * 生成路由
     *
     * @param serverType 服务类型
     * @return
     */
    @Override
    public ApiResponse<?> createRouter(String serverType) {
        QueryWrapper<SMenu> sMenuQueryWrapper = new QueryWrapper<>();
        sMenuQueryWrapper.select("id", "menu_route").eq("server_type", serverType);
        List<SMenu> pMenus = sMenuMapper.selectList(sMenuQueryWrapper);
        return ApiResponse.success(pMenus);
    }

    /**
     * 获取微件列表
     *
     * @param serverType 服务类型
     * @return
     */
    @Override
    public ApiResponse<?> getWidgetsList(String serverType) {
        List<SMenuDTO> widgetsList = sMenuMapper.getWidgetsList(serverType);
        return ApiResponse.success(widgetsList);
    }
}
