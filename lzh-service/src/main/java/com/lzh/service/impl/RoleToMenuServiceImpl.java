package com.lzh.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lzh.entity.RoleToMenu;
import com.lzh.mapper.RoleToMenuMapper;
import com.lzh.service.IRoleToMenuService;
import com.lzh.util.CommonUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleToMenuServiceImpl extends ServiceImpl<RoleToMenuMapper, RoleToMenu> implements IRoleToMenuService {
    @Override
    public List<RoleToMenu> selectByRoleCode(String roleId) {
        EntityWrapper<RoleToMenu> ew = new EntityWrapper<>();
        ew.where("role_code={0}", roleId);
        return this.selectList(ew);
    }

    @Override
    public boolean saveAll(String roleCode, List<String> menuCodes) {
        boolean result = true;
        if (!CommonUtil.isEmpty(menuCodes)) {
            List<RoleToMenu> modelList = new ArrayList<>();
            for (String menuCode : menuCodes) {
                modelList.add(RoleToMenu.builder().roleCode(roleCode).menuCode(menuCode).build());
            }
            result = this.insertBatch(modelList);
        }
        return result;
    }

    @Override
    public boolean deleteAllByRoleCode(String roleCode) {
        EntityWrapper<RoleToMenu> ew = new EntityWrapper<>();
        ew.where("role_code={0}", roleCode);
        return this.delete(ew);
    }
}
