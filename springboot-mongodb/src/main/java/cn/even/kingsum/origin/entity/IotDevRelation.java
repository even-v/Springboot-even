package cn.even.kingsum.origin.entity;

/**
 * 漏水监测设备规则
 * @author king
 *
 */
public class IotDevRelation {
	
	public static final String collName = "iot_dev_relation";
	
	/***/
	public static final String _id = "_id";
	
	/** 业主单位ID **/
	public static final String unitId = "unitId";
	
	/** 疑似漏水的设备**/
	public static final String iotDeviceAddr = "iotDeviceAddr";
	
	/**需要关闭的设备**/
	public static final String colseDevice = "colseDevice";
	
	/**需要监测的设备**/
	public static final String monitorDec = "monitorDec";

}
