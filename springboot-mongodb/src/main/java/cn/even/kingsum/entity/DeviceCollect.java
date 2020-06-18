package cn.even.kingsum.entity;

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
@TableName("iot_device_collect")

public class DeviceCollect extends BaseEntity<DeviceCollect>{
    private static final long serialVersionUID = 1L;

    /**
     * 传感器采集项目名称
     */
    @TableField("item")
    private Integer item;

    /**
     * 采集模型端口
     */
    @TableField("model_no")
    private String modelNo;

    /**
     * 采集类型
     */
    @TableField("type")
    private Integer type;

    /**
     * 采集转换端口
     */
    @TableField("convert_no")
    private Integer convertNo;

    /**
     * 采集通道口
     */
    @TableField("channel_no")
    private Integer channelNo;

//    /**
//     * 电流
//     */
//    @TableField("current")
//    private Integer current;

    /**
     * 设备ID
     */
    @TableField("device_id")
    private String deviceId;



}