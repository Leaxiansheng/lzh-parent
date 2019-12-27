package com.lzh.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lzh.base.Constant;
import com.lzh.entity.Menu;
import com.lzh.mapper.MenuMapper;
import com.lzh.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> selectByIds(List<Integer> permissionIds) {
        EntityWrapper<Menu> ew = new EntityWrapper<>();
        ew.in("menu_id", permissionIds);
        return this.selectList(ew);
    }

    @Override
    public List<Menu> findMenuByRoleCode(String roleCode) {
        return menuMapper.findMenuByRoleCode(roleCode);
    }

    @Override
    public List<Menu> treeMenuList(String pId, List<Menu> list) {
        List<Menu> IteratorMenuList = new ArrayList<>();
        for (Menu m : list) {
            if (String.valueOf(m.getParentId()).equals(pId)) {
                List<Menu> childMenuList = treeMenuList(String.valueOf(m.getMenuId()), list);
                m.setChildMenu(childMenuList);
                if(m.getMenuType() == Constant.TYPE_MENU){
                    IteratorMenuList.add(m);
                }
            }
        }
        return IteratorMenuList;
    }
}
