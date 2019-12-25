package com.lzh.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.*;

import java.io.Serializable;

/**
 * 角色菜单关系表
 */
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_role_to_menu")
public class RoleToMenu extends Model<RoleToMenu> {

    private static final long serialVersionUID = 3582876080432501182L;
    /**
     * 主键
     */
    @TableId(value = "role_to_menu_id", type = IdType.AUTO)
    private Integer roleToMenuId;
    /**
     * 角色代号
     */
    @TableField("role_code")
    private String roleCode;
    /**
     * 菜单代号,规范权限标识
     */
    @TableField("menu_code")
    private String menuCode;

    @Override
    protected Serializable pkVal() {
        return this.roleToMenuId;
    }
}
