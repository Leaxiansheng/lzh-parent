package com.lzh.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lzh.base.Constant;
import com.lzh.entity.User;
import com.lzh.entity.UserThirdparty;
import com.lzh.mapper.UserThirdpartyMapper;
import com.lzh.model.ThirdPartyUser;
import com.lzh.service.IUserService;
import com.lzh.service.IUserThirdpartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserThirdpartyServiceImpl extends ServiceImpl<UserThirdpartyMapper, UserThirdparty> implements IUserThirdpartyService {

    @Autowired
    private IUserService userService;

    @Override
    public User insertThirdPartyUser(ThirdPartyUser param, String password) throws Exception {
        User sysUser = User.builder().password(password).username("游客"+param.getOpenid()).mobile(param.getOpenid())
                .avatar(param.getAvatarUrl()).build();
        User register = userService.register(sysUser, Constant.RoleType.USER);
        // 初始化第三方信息
        UserThirdparty thirdparty = UserThirdparty.builder().providerType(param.getProvider()).openId(param.getOpenid()).createTime(System.currentTimeMillis())
                .userNo(register.getUserNo()).status(Constant.ENABLE).accessToken(param.getToken()).build();
        this.insert(thirdparty);
        return register;
    }
}
