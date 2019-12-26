package com.lzh.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.lzh.entity.User;

import java.util.Map;

/**
 * 用户服务类
 */
public interface IUserService extends IService<User> {

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return 用户
     */
    User getUserByUserName(String username);
    /**
     * 根据电话查询用户
     * @param mobile 用户名
     * @return 用户
     */
    User getUserByMobile(String mobile);
    /**
     * 注册用户
     * @param user 用户实体
     * @param roleCode 角色码
     * @return
     */
    User register(User user, String roleCode);

    /**
     * 获取登录用户信息
     * @param user 用户
     * @return
     */
    Map<String, Object> getLoginUserAndMenuInfo(User user);

    /**
     * 删除用户
     * @param userNo
     * @throws Exception
     */
    void deleteByUserNo(String userNo)throws Exception;

    Page<User> selectPageByConditionUser(Page<User> userPage, String info, Integer[] status, String startTime, String endTime);

    Map<String,Object> checkMobileAndPasswd(JSONObject requestJson)throws Exception;

    Map<String,Object> checkMobileAndCatcha(JSONObject requestJson)throws Exception;

    User checkAndRegisterUser(JSONObject requestJson)throws Exception;

    User updateForgetPasswd(JSONObject requestJson)throws Exception;

    void resetMobile(User currentUser, JSONObject requestJson)throws Exception;

    void resetPassWord(User currentUser, JSONObject requestJson)throws Exception;

    User insertUserByAdmin(JSONObject requestJson)throws Exception;
}
