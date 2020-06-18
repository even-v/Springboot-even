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
@TableName("sys_org")

public class Org extends BaseEntity<Org>{
    private static final long serialVersionUID = 1L;

    /**
     * 是否是业主
     */
    @TableField("company_flag")
    private Boolean companyFlag;

    /**
     * 机构等级
     */
    @TableField("level")
    private Integer level;

    /**
     * 火灾危险性
     */
    @TableField("fire_risk")
    private String fireRisk;

    /**
     * 电话
     */
    @TableField("tel")
    private String tel;

    /**
     * 邮件
     */
    @TableField("email")
    private String email;

    /**
     * 手机号
     */
    @TableField("mobile_phone")
    private String mobilePhone;

    /**
     * 其它联系方式
     */
    @TableField("other_contact")
    private String otherContact;

    /**
     * 经度
     */
    @TableField("latitude")
    private String latitude;

    /**
     * 纬度
     */
    @TableField("longitude")
    private String longitude;

    /**
     * 监管单位层级
     */
    @TableField("supervise_level")
    private String superviseLevel;

    /**
     * 联系人性别
     */
    @TableField("sex")
    private String sex;

    /**
     * 机构类型
     */
    @TableField("org_type")
    private Integer orgType;

    /**
     * 机构名称
     */
    @TableField("org_name")
    private String orgName;

    /**
     * 省
     */
    @TableField("prov_id")
    private String provId;

    /**
     * 市
     */
    @TableField("city_id")
    private String cityId;

    /**
     * 县/区
     */
    @TableField("area_id")
    private String areaId;

    /**
     * 机构地址
     */
    @TableField("address")
    private String address;

    /**
     * 是否有效
     */
    @TableField("valid")
    private Boolean valid;

    /**
     * 创建人
     */
    @TableField("create_user")
    private String createUser;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 机构编号
     */
    @TableField("org_code")
    private String orgCode;

    /**
     * 账号数量
     */
    @TableField("account_num")
    private Integer accountNum;

    /**
     * 机构简称
     */
    @TableField("short_name")
    private String shortName;

    @TableField("matching_org")
    private String matchingOrg;

    /**
     * 顶级机构ID
     */
    @TableField("root_org_id")
    private String rootOrgId;

    /**
     * 父节点ID
     */
    @TableField("parent_id")
    private String parentId;

    /**
     * 父节点集体
     */
    @TableField("parent_collectivize")
    private String parentCollectivize;

    /**
     * 父节点监管
     */
    @TableField("parent_supervise")
    private String parentSupervise;

    /**
     * 父节点业主
     */
    @TableField("parent_owner_unit")
    private String parentOwnerUnit;



}