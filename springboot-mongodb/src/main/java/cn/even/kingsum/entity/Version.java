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
@TableName("sys_version")

public class Version extends BaseEntity<Version>{
    private static final long serialVersionUID = 1L;

    /**
     * 系统类型
     */
    @TableField("system_type")
    private Integer systemType;

    /**
     * 版本号
     */
    @TableField("version_code")
    private String versionCode;

//    /**
//     * 软件大小
//     */
//    @TableField("size")
//    private Integer size;

    /**
     * 版本名称
     */
    @TableField("version_name")
    private String versionName;

    /**
     * 是否执行
     */
    @TableField("in_force")
    private Boolean inForce;

    /**
     * 发布内容
     */
    @TableField("content")
    private String content;

    /**
     * 版本发布时间
     */
    @TableField("publish_time")
    private Date publishTime;

    /**
     * 通道
     */
    @TableField("channel")
    private String channel;

    /**
     * 上架和下架
     */
    @TableField("put_away")
    private Boolean putAway;

    /**
     * APPID
     */
    @TableField("app_id")
    private Integer appId;

    /**
     * APP 名称
     */
    @TableField("app_name")
    private String appName;



}