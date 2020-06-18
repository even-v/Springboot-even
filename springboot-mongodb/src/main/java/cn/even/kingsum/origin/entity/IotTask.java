package cn.even.kingsum.origin.entity;

/**
 * 对时、巡检和查询任务表
 * 
 * @author Administrator
 *
 */
public class IotTask {

	public static final String collName = "iot_task";

	/***/
	public static final String _id = "_id";
	/***/
	public static final String unitId = "unitId";
	/** 传输装置设备ID **/
	public static final String deviceId = "deviceId";
	/** 传输装置设备名称 **/
	public static final String deviceName = "deviceName";
	/** 传输装置编号 **/
	public static final String transportId = "transportId";
	/** 传输装置编号 **/
	public static final String place = "place";
	/**  **/
	public static final String ctrl = "ctrl";
	/** 任务状态 TaskStatusEnum 枚举类里 **/
	public static final String taskStatus = "taskStatus";
	/** 任务类型 TaskTypeEnum 枚举类里 **/
	public static final String taskType = "taskType";
	/** 开始时间 **/
	public static final String startDate = "startDate";
	/** 返回结果时间 **/
	public static final String endDate = "endDate";
	/** **/
	public static final String online = "online";
	/** 对时返回说明 **/
	public static final String message = "message";
	/** 对时返回说明 TaskResultEnum枚举类 **/
	public static final String patrolResult = "patrolResult";
	
}