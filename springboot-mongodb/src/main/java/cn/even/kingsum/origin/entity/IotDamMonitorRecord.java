package cn.even.kingsum.origin.entity;

/**
 * dam监测设备上传数据记录
 *
 */
public class IotDamMonitorRecord{

	public static final String collName = "iot_dam_monitor_record";

	/***/
	public static final String _id = "_id";
	/*** --------------------  设备信息表中查询出来的信息    ----------**/
	/** 业主单位ID **/
	public static final String unitId = "unitId";
	/** 建筑物ID **/
	public static final String buildingId = "buildingId";
	/** 设备ID **/
	public static final String deviceId = "deviceId";
	/** 设备系统类型 **/
	public static final String fireSysType = "fireSysType";
	/** 设备监测类型 **/
	public static final String fireDeviceType = "fireDeviceType";
	/** 设备名称 **/
	public static final String deviceName = "deviceName";
	/** 安装楼层 **/
	public static final String floorName = "floorName";
	/**
	 * 异常时间
	 */
	public static final String receiveDate = "receiveDate";
	
	/** 安装地址 **/
	public static final String place = "place";

	//--------------------- 采集上传上来和运算的信息 -----------------
	/** 传感器采集项目名称 **/
	public static final String collect = "collect";
	/** 传感器采集项目名称 **/
	public static final String collect_item = "collect_item";
	/** 传感器采集项目单位 **/
	public static final String collect_unit = "collect_unit";
	/** 传感器采集项目原始值 **/
	public static final String collect_oriValue = "collect_oriValue";
	/** 放大倍数 **/
	public static final String collect_scale = "collect_scale";
	/** 传感器采集项目计算后真实值 **/
	public static final String collect_value = "collect_value";
	/** 默认值正常参数值 如防火门正常为1 ， 水位1.2-1.5 **/
	public static final String default_value = "default_value";
	
	/** 运行状态  1 正常，2异常，3失联 **/
	public static final String collect_status = "collect_status";
	/** 设备监测数据描述 
	 * 	81 未达下限
		82 正常
		83 超过数据上限
		50 防火门异常关闭
		51 防火门异常打开
	 **/
	public static final String collect_status_sub = "collect_status_sub";
	/** 传输装置编号 **/
	public static final String transportId = "transportId";
	/** 转换器地址编号 **/
	public static final String convertNo = "convertNo";
	/** 转换器端口号 **/
	public static final String channelNo = "channelNo";
	/** 原始采集数据 **/
	public static final String source_data = "source_data";
	/** 传输装置Ip **/
	public static final String ip = "ip";
	/** 传输装置端口 **/
	public static final String port = "port";
	
}