package cn.even.kingsum.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import cn.even.common.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jiangjingwei@yysoft.org.cn
 * @since 2020-06-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_role_menu")

public class RoleMenu extends BaseEntity<RoleMenu>{
    private static final long serialVersionUID = 1L;

    /**
     * 是否删除
     */
    @TableField("deleted")
    private Boolean deleted;

    /**
     * 菜单ID
     */
    @TableField("menu_id")
    private String menuId;

    /**
     * 角色ID
     */
    @TableField("role_id")
    private String roleId;



}