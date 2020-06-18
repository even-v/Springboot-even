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
@TableName("iot_park")

public class Park extends BaseEntity<Park>{
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
     * 鸟瞰图
     */
    @TableField("aerial_view_pic")
    private String aerialViewPic;

    /**
     * 1为有效 0为删除 
     */
    @TableField("status")
    private Boolean status;

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



}