package com.lucky.sgr.app.data.center.MenuTree;

import cn.hutool.json.JSONUtil;
import com.lucky.sgr.app.data.center.MenuTree.entity.Menu;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author：LuckySgr.
 * @date: 2023/2/14
 */
public class MenuTreeTest {

    @Test
    void TestMenu() {
        List<Menu> menus = Arrays.asList(
                new Menu(1, "根节点", 0),
                new Menu(2, "子节点1", 1),
                new Menu(3, "子节点1.1", 2),
                new Menu(4, "子节点1.2", 2),
                new Menu(5, "子节点1.3", 2),
                new Menu(6, "根节点2", 1),
                new Menu(7, "根节点2.1", 6),
                new Menu(8, "根节点2.2", 6),
                new Menu(9, "根节点2.2.1", 7),
                new Menu(10, "根节点2.2.2", 7),
                new Menu(11, "根节点3", 1),
                new Menu(12, "根节点3.1", 11)
        );

        // 获取根节点
        List<Menu> collect = menus.stream().filter(m -> m.getParentId() == 0).peek(
                m -> m.setChildList(getChildren(m, menus))
        ).collect(Collectors.toList());
        String s = JSONUtil.toJsonPrettyStr(collect);
        System.out.println(s);
    }

    /**
     * 递归查询子节点
     * @param root 根节点
     * @param all 所有节点
     * @return 根节点信息
     */
    private List<Menu> getChildren(Menu root, List<Menu> all) {
        return all.stream().filter(m -> Objects.equals(m.getParentId(), root.getId())).peek(
                m -> m.setChildList(getChildren(m, all))
        ).collect(Collectors.toList());
    }
}
