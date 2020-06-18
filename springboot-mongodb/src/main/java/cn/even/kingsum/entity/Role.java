package cn.even.kingsum.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
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
@TableName("sys_role")

public class Role extends BaseEntity<Role>{
    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
    @TableField("name")
    private String name;

    /**
     * 描述
     */
    @TableField("desc")
    private String desc;

    /**
     * 机构ID
     */
    @TableField("org_id")
    private String orgId;

    /**
     * 系统ID
     */
    @TableField("system_id")
    private String systemId;

    /**
     * 状态
     */
    @TableField("status")
    private Integer status;

    /**
     * 菜单类型
     */
    @TableField("system_type")
    private Integer systemType;

    /**
     * 是否是管理角色
     */
    @TableField("admin")
    private Boolean admin;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 创建人
     */
    @TableField("create_user")
    private String createUser;



}