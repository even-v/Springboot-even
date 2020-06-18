package cn.even.kingsum.origin.util;
/**
 * 第三方请求地址
 * @author Administrator
 *
 */
public class ConstantPath {

	//查询出当前节点的所有下级单位
	public final static String findOrgTreeUrl = "/platform/admin/sysorg/findOrgTree.do";
	
	//查询出当前节点的所有下级社会单位
	public final static String findOrgListUrl = "/platform/admin/sysorg/findOrgList.do";

	//查询出当前节点的所有下级社会单位
	public final static String findOrgCountUrl = "/platform/admin/sysorg/findOrgCount.do";

	//集团化用户列表
	public final static String findUserList = "/platform/admin/user/findUserList.do";
	//集团化添加用户
	public final static String addUser = "platform/admin/user/addUserByClique.do";
	//修改用户信息
	public final static String updateUserInfo = "/platform/admin/user/upUserInfoByClique.do";
	//修改用户详情
	public final static String findDetail = "/platform/admin/user/findDetail.do";

	//集团化人员列表
	public final static String findEmployeeList = "/platform/admin/employee/employeeList.do";
	//集团化角色列表
	public final static String findRoleList = "/platform/admin/user/findRoleList.do";

	public final static String findNextLeveList = "/platform/admin/sysorg/getNextLeveOrg.do";

 	//设备用户状态
	public final static String setUserStat = "/platform/admin/user/setUserStat.do";
	
	//查询组织机构的父节点
	public final static String findOrgPentent = "/platform/admin/sysorg/findOrgPentent.do";

	//传输装置命令查岗
	public final static String inscpectUrl = "/device/inscpect";
	//传输装置命令对时
	public final static String syncTimeUrl = "/device/synctime";
	//传输装置命令运行状态
	public final static String runStatusUrl = "/device/runstatus";
	
	//-------------- 佳岚用电装置控制
	public static final String SWITCH_STATUS_URL = "/jl/update/switch";// 设备开关
	public static final String MQTT_STATUS_URL = "/jl/update/mqtt";// mqtt服务地址
	public static final String WIFI_STATUS_URL = "/jl/update/wifi";// 无线配置
	public static final String SETTING_STATUS_URL = "/jl/update/setting";// 设置参数配置
	
}
