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
@TableName("iot_park_principal")

public class ParkPrincipal extends BaseEntity<ParkPrincipal>{
    private static final long serialVersionUID = 1L;

    /**
     * 园区编号
     */
    @TableField("park_no")
    private String parkNo;

    /**
     * 园区名称
     */
    @TableField("park_name")
    private String parkName;

    /**
     * 业主单位ID
     */
    @TableField("unit_id")
    private String unitId;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 是否主要负责人
     */
    @TableField("main")
    private Boolean main;

    /**
     * 负责人名称
     */
    @TableField("principal_name")
    private String principalName;

    /**
     * 负责人电话
     */
    @TableField("principal_telephone")
    private String principalTelephone;

    /**
     * 负责人ID
     */
    @TableField("principal_id")
    private String principalId;



}