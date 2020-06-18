package cn.even.kingsum.origin.entity;

/**
 * 巡查记点位信息表
 * @author Administrator
 *
 */
public class FirePatrolDevice {

	public static final String collName = "fire_patrol_device";

	/**id*/
	public static final String _id = "_id";
	/**业主id*/
	public static final String unitId = "unitId";
	/***/
	public static final String buildingId = "buildingId";
	/***/
	public static final String buildName = "buildName";
	/**楼层号*/
	public static final String floorNo = "floorNo";
	/**楼层名称*/
	public static final String floorName = "floorName";
	//分区房间
	public static final String partitionNo = "partitionNo";
	public static final String partitionDescribe = "partitionDescribe";
	/**点位编号id*/
	public static final String pointId = "pointId";
	/***/
	public static final String pointCode = "pointCode";
	/**点位名称*/
	public static final String pointName = "pointName";
	/**点位位置*/
	public static final String pointAddr = "pointAddr";

	public static final String pointStatus = "deviceStatus";
	public static final String deviceStatus = "deviceStatus";
	public static final String qrCode = "qrCode";
	
	public static final String source = "source";
	public static final String createTime = "createTime";
	public static final String remarks = "remarks";
	
	
	
	
	/** 所要巡查的设备信息  **/
	public static final String deviceInfo = "deviceInfos";
	public static final String deviceName = "deviceName";
	public static final String brandName = "brandName";
	public static final String deviceModel = "deviceModel";
	public static final String deviceAddr = "deviceAddr";
	public static final String fireSysType = "fireSysType";
	public static final String fireDeviceType = "fireDeviceType";
	public static final String deviceValidDate = "deviceValidDate";

	public static final String parkId = "parkId";
	public static final String parkName = "parkName";
}