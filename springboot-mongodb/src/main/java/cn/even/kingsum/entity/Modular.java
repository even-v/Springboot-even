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
@TableName("sys_modular")

public class Modular extends BaseEntity<Modular>{
    private static final long serialVersionUID = 1L;

    /**
     * 模块名称
     */
    @TableField("name")
    private String name;

    /**
     * 模块描述
     */
    @TableField("desc")
    private String desc;

    /**
     * 状态
     */
    @TableField("status")
    private Integer status;

    /**
     * 模块类型
     */
    @TableField("modular_type")
    private Integer modularType;



}