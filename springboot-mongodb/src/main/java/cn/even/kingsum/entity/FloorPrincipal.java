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
 * 建筑物 - 楼层 - 楼层负责人
 * </p>
 *
 * @author jiangjingwei@yysoft.org.cn
 * @since 2020-06-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("socialunit_floor_principal")

public class FloorPrincipal extends BaseEntity<FloorPrincipal>{
    private static final long serialVersionUID = 1L;

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
     * 楼层编号
     */
    @TableField("floor_no")
    private Integer floorNo;

    /**
     * 楼层名称
     */
    @TableField("floor_name")
    private String floorName;

    /**
     * 创建人ID
     */
    @TableField("create_user")
    private String createUser;

    /**
     * 楼层状态
     */
    @TableField("status")
    private Integer status;

    /**
     * 真实楼层编号
     */
    @TableField("real_no")
    private Integer realNo;

    /**
     * 楼层高度
     */
    @TableField("floor_height")
    private Double floorHeight;

    /**
     * 楼层图片
     */
    @TableField("floor_pic")
    private String floorPic;

    /**
     * bimcid
     */
    @TableField("bimcid")
    private String bimcid;

    /**
     * 建筑物ID
     */
    @TableField("building_id")
    private String buildingId;

    /**
     * 园区ID
     */
    @TableField("park_id")
    private String parkId;

    /**
     * 区域
     */
    @TableField("region")
    private String region;

    /**
     * 楼层负责人ID
     */
    @TableField("principal_id")
    private String principalId;

    /**
     * 楼层负责人名字
     */
    @TableField("principal_name")
    private String principalName;

    /**
     * 楼层ID
     */
    @TableField("floor_id")
    private String floorId;



}