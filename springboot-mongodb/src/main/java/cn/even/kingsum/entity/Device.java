package cn.even.kingsum.entity;

import java.math.BigDecimal;
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
@TableName("iot_device")

public class Device extends BaseEntity<Device>{
    private static final long serialVersionUID = 1L;

    /**
     * 业主单位ID
     */
    @TableField("unit_id")
    private String unitId;

    /**
     * 建筑ID
     */
    @TableField("building_id")
    private String buildingId;

    /**
     * 建筑名称
     */
    @TableField("build_name")
    private String buildName;

    /**
     * 楼层名称
     */
    @TableField("floor_name")
    private String floorName;

    /**
     * 地点
     */
    @TableField("place")
    private String place;

    /**
     * 设备模型
     */
    @TableField("device_model")
    private String deviceModel;

    /**
     * 设备名称
     */
    @TableField("device_name")
    private String deviceName;

    /**
     * 设备类型
     */
    @TableField("device_type")
    private Integer deviceType;

    /**
     * 设备品牌
     */
    @TableField("device_Brand")
    private String deviceBrand;

    /**
     * 安装界面
     */
    @TableField("install_interface")
    private String installInterface;

    /**
     * 设备状态
     */
    @TableField("device_status")
    private Integer deviceStatus;

    /**
     * 系统大类
     */
    @TableField("fire_sys_type")
    private String fireSysType;

    /**
     * 系统小类
     */
    @TableField("fire_device_type")
    private String fireDeviceType;

    /**
     * x轴坐标
     */
    @TableField("x_asix")
    private BigDecimal xAsix;

    /**
     * y轴坐标
     */
    @TableField("y_asix")
    private BigDecimal yAsix;

    /**
     * 传输网关编号
     */
    @TableField("addr_transport_id")
    private String addrTransportId;

    /**
     * 传输装置系统地址号
     */
    @TableField("addr_system_addr")
    private Integer addrSystemAddr;

    /**
     * 控制器号
     */
    @TableField("addr_controller_no")
    private Integer addrControllerNo;

    /**
     * 回路号
     */
    @TableField("addr_area_no")
    private Integer addrAreaNo;

    /**
     * 地址号
     */
    @TableField("addr_place_no")
    private Integer addrPlaceNo;

    /**
     * CRTKey校验
     */
    @TableField("addr_CRT_key")
    private String addrCrtKey;

    /**
     * 设备ID号
     */
    @TableField("addr_equip_no")
    private String addrEquipNo;

    /**
     * 设备编号
     */
    @TableField("addr_equip_no_int")
    private Integer addrEquipNoInt;

    /**
     * 运行状态
     */
    @TableField("run_status")
    private Integer runStatus;

    /**
     * 运行时间
     */
    @TableField("run_time")
    private Integer runTime;

    /**
     * bimX轴
     */
    @TableField("bim_x")
    private String bimX;

    /**
     * bimY轴
     */
    @TableField("bim_y")
    private String bimY;

    /**
     * bimZ轴
     */
    @TableField("bim_z")
    private String bimZ;

    @TableField("source")
    private Integer source;

    /**
     * 标签编号
     */
    @TableField("tag_no")
    private String tagNo;

    /**
     * 楼层编号
     */
    @TableField("floor_no")
    private String floorNo;

    /**
     * 分区/房间编号
     */
    @TableField("partition_no")
    private String partitionNo;

    /**
     * 分区名称
     */
    @TableField("partition_name")
    private String partitionName;

//    /**
//     * 电流
//     */
//    @TableField("current")
//    private Integer current;

    /**
     * 描述
     */
    @TableField("info_remark")
    private String infoRemark;

    /**
     * 单/双防火门 0为单，1为双
     */
    @TableField("many_fan")
    private Boolean manyFan;



}