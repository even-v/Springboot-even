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
@TableName("sys_menu")

public class Menu extends BaseEntity<Menu>{
    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
    @TableField("name")
    private String name;

    /**
     * 描述
     */
    @TableField("desc")
    private String desc;

    /**
     * 菜单URL
     */
    @TableField("url")
    private String url;

    /**
     * 排序号
     */
    @TableField("sequence")
    private Integer sequence;

    /**
     * 父菜单ID
     */
    @TableField("parent")
    private String parent;

    /**
     * 菜单系统ID
     */
    @TableField("system_id")
    private Integer systemId;

    /**
     * 状态
     */
    @TableField("status")
    private Integer status;

    /**
     * 图标URL
     */
    @TableField("icon_url")
    private String iconUrl;

    /**
     * app端是否展现
     */
    @TableField("app_view")
    private Integer appView;

    /**
     * 菜单分类
     */
    @TableField("system_type")
    private Integer systemType;

    /**
     * 所属模块ID
     */
    @TableField("modular_id")
    private String modularId;



}