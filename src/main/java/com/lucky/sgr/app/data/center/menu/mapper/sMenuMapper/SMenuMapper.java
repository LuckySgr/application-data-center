package com.lucky.sgr.app.data.center.menu.mapper.sMenuMapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lucky.sgr.app.data.center.menu.domain.dto.sMenuDto.SMenuDTO;
import com.lucky.sgr.app.data.center.menu.domain.entity.sMenu.SMenu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author：LuckySgr.
 * @date: 2023/2/14
 */
@Component
public interface SMenuMapper extends BaseMapper<SMenu> {

    @Select("select id, (select menu_name from p_menu where s_menu.p_id = p_menu.id) as pMenuName, menu_name, is_enable from s_menu where server_type = #{serverType}")
    List<SMenuDTO> getSMenuInfo(String serverType);

    @Update("update s_menu set is_enable = #{isEnable} where id = #{id}")
    int updateById(@Param("isEnable") int isEnable, @Param("id") String id);

    @Select("select id, (select menu_name from p_menu where s_menu.p_id = p_menu.id) as pMenuName, menu_name, menu_route, menu_icon, is_enable, create_time, update_time from s_menu where server_type = #{serverType}")
    List<SMenuDTO> getWidgetsList(String serverType);
}
