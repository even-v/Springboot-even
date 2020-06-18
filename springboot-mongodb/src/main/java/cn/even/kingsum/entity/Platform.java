package cn.even.kingsum.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import cn.even.common.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 机构平台表
 * </p>
 *
 * @author jiangjingwei@yysoft.org.cn
 * @since 2020-06-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("org_platform")

public class Platform extends BaseEntity<Platform>{
    private static final long serialVersionUID = 1L;

    /**
     * 机构名称
     */
    @TableField("name")
    private String name;

    /**
     * 机构类型
     */
    @TableField("org_type")
    private Integer orgType;



}