package com.lzh.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.*;

import java.io.Serializable;

/**
 * 角色表
 */
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_role")
public class Role extends Model<Role> {

    private static final long serialVersionUID = -6654728156716896271L;
    /**
     * 角色名称
     */
    @TableField("role_name")
    private String roleName;

    /**
     * 角色代号主键
     */
    @TableId("role_code")
    private String roleCode;

    @Override
    protected Serializable pkVal() {
        return this.roleCode;
    }
}
