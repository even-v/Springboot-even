package cn.even.kingsum.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import cn.even.common.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 设备的区域建筑/设备的有效范围
 * </p>
 *
 * @author jiangjingwei@yysoft.org.cn
 * @since 2020-06-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("iot_device_buildings")

public class DeviceBuildings extends BaseEntity<DeviceBuildings>{
    private static final long serialVersionUID = 1L;

    /**
     * 设备ID
     */
    @TableField("device_id")
    private String deviceId;

    /**
     * 建筑物ID
     */
    @TableField("building_id")
    private String buildingId;



}