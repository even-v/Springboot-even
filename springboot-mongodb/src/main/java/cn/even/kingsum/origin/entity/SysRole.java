package cn.even.kingsum.origin.entity;
public class SysRole{

	public static final String collName = "sys_role";

	/*主键**/
	public static final String _id = "_id";
	/*名字**/
	public static final String name = "name";
	/*描述**/
	public static final String desc = "desc";
	/*创建角色的机构 平台创建的无需设置**/
	public static final String orgId = "orgId";
	/*状态  0有效 1 无效**/
	public static final String status = "status";
	/***/
	public static final String systemId = "systemId";
	/*菜单集合**/
	public static final String menus = "menus";
	/*接口集合**/
	public static final String interfaces = "interfaces";
	/**是否是管理员角色（无效字段）*/
	public static final String isAdmin = "isAdmin";
	/**
	 * 系统类型
	 */
	public static final String sysType = "sysType";
	
	public static final String createTime = "createTime";
	
	public static final String updateTime = "updateTime";
	
	public static final String createUser  = "createUser";
	
}