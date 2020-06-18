package cn.even.kingsum.origin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.Data;

@Data
public class SysOrg {

	public static final String collName = "sys_org";
	/**主键*/
	private   String _id ;
	/**组织代码*/
	private   String orgCode ;
	/**组织名称*/
	private   String orgName ;
	/**所属省份*/
	private   String provId ;
	/**所属城市*/
	private   String cityId ;
	/**所属区县*/
	private   String areaId;
//	/**父节点 (JSONOBject对象)*/
	private   String parentArr ;

	/**父节点 (JSONOBject对象)*/
//	private JSONPObject parentArr;

	/**是否有效  1有效 0无效*/
	private   String isVal;
	/**系统类型*/
	private   String orgType ;
	/**当前组织层级*/
	private   String level ;
	/**是不是业主单位*/
	private   String compflag;

	private   String createTime ;

	private   String createUser ;

	private   String updateTime ;
	/***/
	private   String remark ;
	/***/
	private   String infoMore ;
	/**开通模块集合*/
	private   String modularIdArr ;

	private   String shortName ;
	/**监管*/
	private   String matchingOrg ;
	/**组织机构图标*/
	private   String orgPic ;
	
	/**
	 * 视频监控 悠咯客的商铺id 如没有则为空
	 */
	private   String storeId ;

	private String rootOrgId;

	private String fireRisk;

	private String address;

	private String sex;

	private Integer accountNum;

	/**
	 * 电话
	 */
	@TableField("tel")
	private String tel;

	/**
	 * 邮件
	 */
	@TableField("email")
	private String email;

	/**
	 * 手机号
	 */
	@TableField("mobile_phone")
	private String mobilePhone;

	/**
	 * 其它联系方式
	 */
	@TableField("other_contact")
	private String otherContact;

	/**
	 * 经度
	 */
	@TableField("latitude")
	private String latitude;

	/**
	 * 纬度
	 */
	@TableField("longitude")
	private String longitude;

	/**
	 * 监管单位层级
	 */
	@TableField("supervise_level")
	private String superviseLevel;
}

