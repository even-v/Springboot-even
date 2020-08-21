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
 * 消防设施设备
 * </p>
 *
 * @author jiangjingwei@yysoft.org.cn
 * @since 2020-07-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_fire_facility")
public class FireFacility extends BaseEntity<FireFacility> {
    private static final long serialVersionUID = 1L;

    /**
     * 是否删除
     */
    @TableField("deleted")
    private Boolean deleted;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 设施名称
     */
    @TableField("name")
    private String name;

    /**
     * 设施备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 系统ID
     */
    @TableField("module_id")
    private String moduleId;

    /**
     * 系统名称
     */
    @TableField("module_name")
    private String moduleName;

    /**
     * 系统备注
     */
    @TableField("module_remark")
    private String moduleRemark;

    /**
     * 系统类型：
     * 1：巡查设施类型
     * 2：监测控制设备类型
     * 3：消防电源监测设备类型
     */
    @TableField("type")
    private String type;

    /**
     * 序号
     */
    @TableField("sequence")
    private Integer sequence;


}