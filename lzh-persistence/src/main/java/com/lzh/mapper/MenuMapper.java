package com.lzh.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lzh.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单mapper接口
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> findMenuByRoleCode(@Param("roleCode") String roleCode);
}
