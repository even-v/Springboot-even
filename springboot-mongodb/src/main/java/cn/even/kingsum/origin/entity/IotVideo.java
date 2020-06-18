package cn.even.kingsum.origin.entity;

/**
 * 视频管理
 * 
 * @author Administrator
 *
 */
public class IotVideo {

	public static final String collName = "iot_video";

	/***/
	public static final String _id = "_id";

	/** 业主名称 */
	public static final String orgName = "orgName";

	/** 业主Id */
	public static final String unitId = "unitId";

	/** 安装建筑单位ID **/
	public static final String buildingId = "buildId";
	/** 建筑名称 */
	public static final String buildName = "buildName";
	/** 楼层编号 */
	public static final String floorNo = "floorNo";
	/** 楼层名称 */
	public static final String floorName = "floorName";
	/** 设备名称 **/
	public static final String videoName = "videoName";
	/** 视频设备通道 **/
	public static final String channelNo = "channelNo";
	/** 设备安装地址 **/
	public static final String place = "place";
	/** 视频码率 **/
	public static final String rate = "rate";
	/** 分区/房间 编号 **/
	public static final String partitionNo = "partitionNo";
	/** 分区/房间 名称 **/
	public static final String partitionName = "partitionName";
	/** 视频设备悠络客标识号 **/
	public static final String deviceIdYLK = "deviceIdYLK";
	/** 设备运行状态 1为正常，2 为异常失联 **/
	public static final String runStatus = "runStatus";

	/**
	 * 悠咯客设备id 数字编码
	 */
	public static final String deviceAutoId = "deviceAutoId";

	/**
	 * 视频分析检测间隔时间
	 */
	public static final String intervalTime = "intervalTime";

	/**
	 * 设备类型。球型，枪型
	 */
	public static final String deviceType = "deviceType";
	/**
	 * 云瀑设备id
	 */
	public static final String deviceIdYP = "deviceIdYP";
	/** 是否删除 1是正常。0为删除 DeviceEnum.DeviceStatus **/
	public static final String deviceStatus = "deviceStatus";
	/*
	 * 创建时间
	 */
	public static final String createTime = "createTime";
	public static final String upDateTime = "upDateTime";

	/**
	 * 设备属性  1.普通  2 火灾。3通道。4.消控室
	 */
	public static final String deviceProperties = "deviceProperties";
	
	public static final String recentReportingTime = "recentReportingTime";
	

	public static final String xAsix = "xAsix";
	/***/
	public static final String yAsix = "yAsix";
	
	
}