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
@TableName("sys_user")

public class User extends BaseEntity<User>{
    private static final long serialVersionUID = 1L;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 创建人ID
     */
    @TableField("create_user_id")
    private String createUserId;

    /**
     * 账号
     */
    @TableField("account")
    private String account;

    /**
     * 名称
     */
    @TableField("name")
    private String name;

    /**
     * 状态
     */
    @TableField("status")
    private Integer status;

    /**
     * 是否是管理员
     */
    @TableField("admin")
    private Boolean admin;

    /**
     * 电话
     */
    @TableField("telephone")
    private String telephone;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 机构ID
     */
    @TableField("org_id")
    private String orgId;

    /**
     * 修改人ID
     */
    @TableField("update_user")
    private String updateUser;

    /**
     * 账号类型
     */
    @TableField("org_type")
    private Integer orgType;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 系统ID
     */
    @TableField("system_id")
    private Integer systemId;

    /**
     * 人员ID
     */
    @TableField("emp_id")
    private String empId;



}