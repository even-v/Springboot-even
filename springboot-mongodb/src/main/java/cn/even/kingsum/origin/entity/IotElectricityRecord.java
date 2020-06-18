package cn.even.kingsum.origin.entity;

/**
 * 用电安全记录表
 * 
 * @author Administrator
 *
 */
public class IotElectricityRecord {

	public static final String collName = "iot_electricity_record";

	/***/
	public static final String _id = "_id";
	/***/
	public static final String unitId = "unitId";
	/***/
	public static final String deviceModel = "deviceModel";
	/***/
	public static final String deviceId = "deviceId";
	/***/
	public static final String deviceName = "deviceName";
	/***/
	public static final String deviceType = "deviceType";
	/***/
	public static final String deviceBrand = "deviceBrand";
	/***/
	public static final String fireSysType = "fireSysType";
	/***/
	public static final String fireDeviceType = "fireDeviceType";

	// bim 模型坐标
	public static final String bimX = "bimX";
	public static final String bimY = "bimY";
	public static final String bimZ = "bimZ";
	/***/
	public static final String xAsix = "xAsix";
	/***/
	public static final String yAsix = "yAsix";
	/***/
	public static final String zoom = "zoom";

	/***/
	public static final String transportId = "transportId";

	/***/
	public static final String iotDeviceAddr = "iotDeviceAddr";
	/***/
	public static final String sysAddr = "sysAddr";
	/***/
	public static final String controllerNo = "controllerNo";
	/***/
	public static final String areaNo = "areaNo";
	/***/
	public static final String placeNo = "placeNo";

	// 设备编号及转换成10进制的数字
	public static final String equipNo = "equipNo";
	public static final String equipNoInt = "equipNoInt";
	
	//记录订阅的类型
	public static final String recordMessageType = "recordMessageType";
	/** 记录类型 ElectricityRecordEnum.RecordType **/
	public static final String recordType = "recordType";
	/** ElectricityRecordEnum.RecordSubType 记录子类型， 热阻违规、手动断电 **/
	public static final String recordSubType = "recordSubType";

	/** 设备运行状态 **/
	public static final String runStatus = "runStatus";
	/** 断电还是通电， 1 为通电，0为断电**/
	public static final String status = "status";
	public static final String receiveDate = "receiveDate";
	public static final String datas = "datas";
	
	/**
	 * 园区编号/名称
	 */
	public static final String parkId = "parkId";
	public static final String parkName = "parkName";

	/***/
	public static final String buildingId = "buildingId";
	/***/
	public static final String buildName = "buildName";
	/***/
	public static final String floorNo = "floorNo";
	public static final String floorName = "floorName";

	/**
	 * 区号/房间号
	 */
	public static final String partitionNo = "partitionNo";
	public static final String partitionName = "partitionName";
	/***/
	public static final String place = "place";

}