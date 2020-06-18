package cn.even.kingsum.origin.entity;

/**
 * Dam 设备监测数据表
 * 保存逻辑：只保存有异常的数据及异常前后一条数据
 * @author Administrator
 *
 */
public class IotDamRunRecord {

	public static final String collName = "iot_dam_run_record";
	

	/**id*/
	public static final String _id = "_id";
	/** 单位ID **/
	public static final String unitId = "unitId";
	/** 用户传输装置里面的source地址 */
	public static final String transportId = "transportId";
	/** 创建记录时间 */
	public static final String receiveDate = "receiveDate";
	/** 转换之后的监测状态 **/
	public static final String runStatus = "runStatus";
	/***/
	public static final String sysType = "sysType";
	/** 报警接收时间 */
	public static final String receiveTime = "receiveTime";
	/** 与设备表关联外键，由transportId-sysAddr-compAddr组成 , 例如  "0000000051003-1-12" */
	public static final String refKey = "refKey";
	/**建筑ID **/
	public static final String buildId = "buildId";
	/**  **/
	public static final String collect_item = "collect_item";
	/****/
	public static final String collect_oriValue = "collect_oriValue";
	/****/
	public static final String collect_scale = "collect_scale";
	/****/
	public static final String collect_unit = "collect_unit";
	/****/
	public static final String collect_value = "collect_value";
	/** 设备ID **/
	public static final String deviceId = "deviceId";
	/** 设备名称 **/
	public static final String deviceName = "deviceName";
	/** 设备状态 **/
	public static final String deviceStatus = "deviceStatus";
	/** 设备类型**/
	public static final String fireDeviceType = "fireDeviceType";
	/** 系统类型**/
	public static final String fireSysType = "fireSysType";
	/** 设备安装地址 **/
	public static final String place = "place";
}
