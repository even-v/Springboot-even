package cn.even.kingsum.origin.entity;

public class IotFireRunRecordHist {

	public static final String collName = "iot_fire_record_hist";

	/** id */
	public static final String _id = "_id";
	/***/
	public static final String receiveDate = "receiveDate";
	/** 警情信息大类 如火警、故障等 **/
	public static final String runStatus = "runStatus";
	/** 消防主机接入地址 **/
	public static final String sysAddr = "sysAddr";
	/** **/
	public static final String sysType = "sysType";
	/** 数据处理状态 -1,"已删除" (0,"待处理"), 1,"已处理"), 2,"复位"), 3,"修复中"), **/
	public static final String dealStatus = "dealStatus";
	/** 处理人 **/
	public static final String dealUser = "dealUser";
	/** 处理时间 **/
	public static final String dealDate = "dealDate";
	/** 处理用户ID **/
	public static final String dealUserId = "dealUserId";
	/** 故障描述 **/
	public static final String reformDescribe = "reformDescribe";
	/** 故障处理图片 **/
	public static final String photos = "photos";
	/** 传输装置ID+主机接入口 **/
	public static final String hostAddr = "hostAddr";
	/** 用户传输装置里面的source地址 */
	public static final String trspId = "trspId";
	/** 报警接收时间 */
	public static final String receiveTime = "receiveTime";
	/** 第一次上传时间 **/
	public static final String firstDate = "firstDate";
	/** 最后上传时间 **/
	public static final String lastDate = "lastDate";
	/** 报警发生时间 */
	public static final String occurTime = "occurTime";
	/** 部件地址 */
	public static final String compAddr = "compAddr";
	/** 报警类型 */
	public static final String alarmType = "alarmType";
	/** 与设备表关联外键，由transportId-sysAddr-compAddr组成 , 例如 "0000000051003-1-12" */
	public static final String refKey = "refKey";
	/** 设备号 */
	public static final String equipNo = "equipNo";

	/** 开始修复，信息 */
	public static final String startRepairInfo = "startRepairInfo";
	/** 开始修复者id */
	public static final String userId = "userId";
	/** 开始时间 */
	public static final String startTime = "startTime";
	/** 开始修复图片 */
	public static final String imgArr = "imgArr";
	/** 开始修复描述 */
	public static final String description = "description";

	/** 修复完成照片 */
	public static final String dealPhotos = "dealPhotos";

	/** 报警设备类型 **/
	public static final String fireType = "fireType";

	// ----------------------------------------------------将删除的字段---------------------------------
	/** 数据源IP */
	public static final String ip = "ip";
	/** 数据源端口 */
	public static final String port = "port";
	/** 采集服务的接收IP */
	public static final String collectIp = "collectIp";
	/***/
	public static final String floorName = "floorName";
	/** 处理结果 */
	public static final String dealResult = "dealResult";
	/***/
	public static final String buildId = "buildId";
	/***/
	public static final String collect_item = "collect_item";
	/***/
	public static final String collect_oriValue = "collect_oriValue";
	/***/
	public static final String collect_scale = "collect_scale";
	/***/
	public static final String collect_unit = "collect_unit";
	/***/
	public static final String collect_value = "collect_value";
	/***/
	public static final String compType = "compType";
	/***/
	public static final String deviceBrand = "deviceBrand";
	/***/
	public static final String deviceId = "deviceId";
	/***/
	public static final String deviceModel = "deviceModel";
	/***/
	public static final String deviceName = "deviceName";
	/***/
	public static final String deviceSN = "deviceSN";
	/***/
	public static final String deviceStatus = "deviceStatus";
	/***/
	public static final String deviceType = "deviceType";
	/***/
	public static final String fireDeviceType = "fireDeviceType";
	/***/
	public static final String fireSysType = "fireSysType";
	/***/
	public static final String floorNo = "floorNo";
	/** 分区/房间编号 **/
	public static final String partitionNo = "partitionNo";
	/** 分区/房间名称 **/
	public static final String partitionName = "partitionName";
	/***/
	public static final String place = "place";
	/***/
	public static final String placeNo = "placeNo";
	/***/
	public static final String tagNo = "tagNo";
	/***/
	public static final String CRTKey = "CRTKey";
	/***/
	public static final String areaNo = "areaNo";
	/***/
	public static final String tagType = "tagType";
	/** 信息传输装置ID **/
	public static final String transportId = "transportId";
	/***/
	public static final String unitId = "unitId";
	/***/
	public static final String xAsix = "xAsix";
	/***/
	public static final String yAsix = "yAsix";
	/***/
	public static final String zoom = "zoom";

	// bim 模型坐标
	public static final String bimX = "bimX";
	public static final String bimY = "bimY";
	public static final String bimZ = "bimZ";

	// 上传时间记录集
	public static final String recordTimes = "recordTimes";
	/**
	 * 2017080313 走势图分析group 解决时间区间问题
	 */
	public static final String groupHour = "groupHour";
	/**
	 * 电流 ma
	 */
	public static final String current = "current";
	/**
	 * 温度 °c
	 */
	public static final String temperature = "temperature";

	/**
	 * 1 电流报警 2 温度报警 3 2个都报警
	 */
	public static final String isOver = "isOver";

}
