package com.lzh.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.IService;
import com.lzh.entity.Notice;
import com.lzh.entity.User;

/**
 * 消息提醒服务接口
 */
public interface INoticeService extends IService<Notice> {

    /**
     *
     * @param themeNo 主题的主键,自己根据业务建立表赋值
     * @param mobile 电话
     */
    void insertByThemeNo(String themeNo,String  mobile);

    void deleteByNotices(User user)throws Exception;

    void read(JSONObject requestJson)throws Exception;
}
