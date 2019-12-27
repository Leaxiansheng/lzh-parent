package com.lzh.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lzh.entity.UserToRole;
import com.lzh.mapper.UserToRoleMapper;
import com.lzh.service.IUserToRoleService;
import com.lzh.util.CommonUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserToRoleServiceImpl extends ServiceImpl<UserToRoleMapper, UserToRole> implements IUserToRoleService {
    @Override
    public UserToRole selectByUserNo(String userNo) {
        EntityWrapper<UserToRole> ew = new EntityWrapper<>();
        ew.where("user_no={0}", userNo);
        List<UserToRole> userToRoleList = this.selectList(ew);
        return CommonUtil.isEmpty(userToRoleList)? null: userToRoleList.get(0);
    }
}
