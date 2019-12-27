package com.lzh.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lzh.entity.InfoToUser;
import com.lzh.mapper.InfoToUserMapper;
import com.lzh.service.IInfoToUserService;
import org.springframework.stereotype.Service;

@Service
public class InfoToUserServiceImpl extends ServiceImpl<InfoToUserMapper, InfoToUser> implements IInfoToUserService {

}
