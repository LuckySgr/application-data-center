package com.lucky.sgr.app.data.center.menu.mapper.pMenuMapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lucky.sgr.app.data.center.menu.domain.entity.pMenu.PMenu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

/**
 * @author：LuckySgr.
 * @date: 2023/2/14
 */
@Component
public interface PMenuMapper extends BaseMapper<PMenu> {

    @Update("update p_menu set is_enable = #{isEnable} where id = #{id}")
    int updateById(@Param("isEnable") int isEnable, @Param("id") String id);
}
