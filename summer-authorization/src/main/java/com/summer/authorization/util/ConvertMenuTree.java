package com.summer.authorization.util;

import com.summer.api.entity.authorization.SysMenu;
import com.summer.api.entity.vo.MenuTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zengfeiyue
 */
public class ConvertMenuTree {


    /**
     * sysmenus convert to menutree
     * @param menuList
     * @return
     */
    public static List<MenuTree> convert(List<SysMenu> menuList){
        List<MenuTree> menuTrees = new ArrayList<>();
        menuList.forEach(sysMenu -> {
            if (sysMenu.getParentId()==0){
                MenuTree menu = new MenuTree();
                menu.setIcon(sysMenu.getIcon());
                menu.setName(sysMenu.getName());
                menu.setTitle(sysMenu.getName());
                menu.setPath(sysMenu.getPath());
                menu.setId(sysMenu.getId());
                menu.setPid(sysMenu.getParentId());
                menuTrees.add(recursive(menu,menuList));
            }
        });
        return menuTrees;
    }

    /**
     * recursive add node to tree
     * @param node
     * @param nodes
     * @return
     */
    public static MenuTree recursive(MenuTree node, List<SysMenu> nodes){
        for (SysMenu treeNode : nodes) {
            if(treeNode.getParentId().equals(node.getId())){
                MenuTree menu = new MenuTree();
                menu.setIcon(treeNode.getIcon());
                menu.setName(treeNode.getName());
                menu.setTitle(treeNode.getName());
                menu.setPath(treeNode.getPath());
                menu.setId(treeNode.getId());
                menu.setPid(treeNode.getParentId());
                node.getChildren().add(menu);
                recursive(menu, nodes);
            }
        }
        return node;
    }
}
