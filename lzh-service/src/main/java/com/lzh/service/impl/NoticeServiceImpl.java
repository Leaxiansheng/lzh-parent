package com.lzh.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lzh.base.BusinessException;
import com.lzh.entity.Notice;
import com.lzh.entity.User;
import com.lzh.mapper.NoticeMapper;
import com.lzh.service.INoticeService;
import com.lzh.util.CommonUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService {
    @Override
    public void insertByThemeNo(String themeNo, String mobile) {
        Notice notice = Notice.builder().themeNo(themeNo).type(1).title("测试通知1111111111")
                //未读
                .mobile(mobile).createTime(System.currentTimeMillis()).isRead(0).build();
        this.insert(notice);
    }

    @Override
    public void deleteByNotices(User user) throws Exception {
        List<Notice> notices = this.selectList(new EntityWrapper<Notice>().eq("mobile",user.getMobile()));
        if(CommonUtil.isEmpty(notices)){
            throw new BusinessException("当前用户不存在消息");
        }else {
            for (Notice notice:notices) {
                this.deleteById(notice.getNoticeId());
            }
        }
    }

    @Override
    public void read(JSONObject requestJson) throws Exception {
        Notice notice = this.selectById(requestJson.getString("noticeId"));
        if(CommonUtil.isEmpty(notice)){
            throw new BusinessException("消息不存在");
        }
        //已读
        notice.setIsRead(requestJson.getInteger("isRead"));
        this.updateById(notice);
    }
}
