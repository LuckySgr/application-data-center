package com.lucky.sgr.app.data.center.MenuTree.entity;

import lombok.Data;

import java.util.List;

/**
 * @author：LuckySgr.
 * @date: 2023/2/14
 */
@Data
public class Menu {
    public Integer id;
    public String name;
    public Integer parentId;
    public List<Menu> childList;

    public Menu(Integer id, String name, Integer parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public Menu(Integer id, String name, Integer parentId, List<Menu> childList) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.childList = childList;
    }
}
