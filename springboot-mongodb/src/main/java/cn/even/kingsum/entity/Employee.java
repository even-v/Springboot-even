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
@TableName("sys_employee")

public class Employee extends BaseEntity<Employee>{
    private static final long serialVersionUID = 1L;

    /**
     * 性别
     */
    @TableField("sex")
    private String sex;

    /**
     * 手机号
     */
    @TableField("mobile")
    private String mobile;

    /**
     * 固定电话
     */
    @TableField("telphone")
    private String telphone;

    /**
     * 邮件
     */
    @TableField("email")
    private String email;

    /**
     * 其它
     */
    @TableField("other")
    private String other;

    /**
     * 员工名
     */
    @TableField("emp_name")
    private String empName;

    /**
     * 员工编号
     */
    @TableField("emp_code")
    private String empCode;

    /**
     * 负责人
     */
    @TableField("rapporteur")
    private String rapporteur;

    /**
     * 部门
     */
    @TableField("dept")
    private String dept;

    /**
     * 扩展
     */
    @TableField("info_more")
    private String infoMore;

    /**
     * 创建人
     */
    @TableField("create_user")
    private String createUser;

    /**
     * 状态
     */
    @TableField("status")
    private Integer status;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 有效性
     */
    @TableField("valid")
    private Boolean valid;

    /**
     * 所属机构ID
     */
    @TableField("org_id")
    private String orgId;



}