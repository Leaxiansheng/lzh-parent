package com.lzh.service;

import com.baomidou.mybatisplus.service.IService;
import com.lzh.entity.User;
import com.lzh.entity.UserThirdparty;
import com.lzh.model.ThirdPartyUser;

/**
 * 第三方用户服务接口
 */
public interface IUserThirdpartyService extends IService<UserThirdparty> {

    User insertThirdPartyUser(ThirdPartyUser param, String password)throws Exception;
}
