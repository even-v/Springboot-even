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
@TableName("socialunit_building")

public class Building extends BaseEntity<Building>{
    private static final long serialVersionUID = 1L;

    /**
     * 业主单位ID
     */
    @TableField("unit_id")
    private String unitId;

    /**
     * 建筑物编码（户籍系统内编号）
     */
    @TableField("build_code")
    private String buildCode;

    /**
     * 建筑名称
     */
    @TableField("build_name")
    private String buildName;

    /**
     * 楼层数
     */
    @TableField("floor_count")
    private Integer floorCount;

    /**
     * 消防室地址
     */
    @TableField("fire_control_address")
    private String fireControlAddress;

    /**
     * 物业管理
     */
    @TableField("build_management")
    private String buildManagement;

    /**
     * 消防设施情况
     */
    @TableField("fire_facilities")
    private String fireFacilities;

    /**
     * 地上层数
     */
    @TableField("ground_layer")
    private Integer groundLayer;

    /**
     * 地下层数
     */
    @TableField("underground_layer")
    private Integer undergroundLayer;

    /**
     * 消防控制室
     */
    @TableField("fire_control_room")
    private Integer fireControlRoom;

    /**
     * 状态
     */
    @TableField("status")
    private Integer status;

    /**
     * 创建人ID
     */
    @TableField("creat_user_id")
    private String creatUserId;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 建筑物高度
     */
    @TableField("area_height")
    private Double areaHeight;

    /**
     * 建筑物图片
     */
    @TableField("build_pic")
    private String buildPic;

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



}