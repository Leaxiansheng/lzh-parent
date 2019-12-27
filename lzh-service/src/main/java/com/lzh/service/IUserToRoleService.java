package com.lzh.service;

import com.baomidou.mybatisplus.service.IService;
import com.lzh.entity.UserToRole;

/**
 * 用户角色关系服务接口
 */
public interface IUserToRoleService extends IService<UserToRole> {
    /**
     * 根据用户ID查询人员角色
     * @param userNo 用户ID
     * @return  结果
     */
    UserToRole selectByUserNo(String  userNo);
}
