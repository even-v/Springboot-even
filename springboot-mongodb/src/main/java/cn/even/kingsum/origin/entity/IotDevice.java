package cn.even.kingsum.origin.entity;

import org.apache.commons.codec.digest.DigestUtils;

public class IotDevice{

	public static final String collName = "iot_device";

	/***/
	public static final String _id = "_id";
	/***/
	public static final String unitId = "unitId";
	/***/
	public static final String buildingId = "buildingId";
	/***/
	public static final String buildName = "buildName";
	/***/
	public static final String floorNo = "floorNo";
	/***/
	public static final String floorName = "floorName";
	/***/
	public static final String place = "place";
	/***/
	public static final String deviceModel = "deviceModel";
	/***/
	public static final String deviceName = "deviceName";
	/***/
	public static final String deviceType = "deviceType";
	/***/
	public static final String deviceBrand = "deviceBrand";
	/***/
	public static final String installInterface = "installInterface";
	/***/
	public static final String deviceStatus = "deviceStatus";
	/***/
	public static final String fireSysType = "fireSysType";
	/***/
	public static final String fireDeviceType = "fireDeviceType";
	/***/
	public static final String xAsix = "xAsix";
	/***/
	public static final String yAsix = "yAsix";
	/***/
	public static final String zoom = "zoom";
	/***/
	public static final String productionDate = "productionDate";

	/**
	 * 防火门类型
	 */
	public static final String isManyFan = "isManyFan";
	
	/***/
	public static final String iotDeviceAddr = "iotDeviceAddr";
	/***/
	public static final String trspId = "trspId";
	/***/
	public static final String sysAddr = "sysAddr";
	/***/
	public static final String controllerNo = "controllerNo";
	/***/
	public static final String areaNo = "areaNo";
	/***/
	public static final String placeNo = "placeNo";
	/**部件地址*/
	public static final String compAddr = "compAddr";
	/***/
	public static final String CRTKey = "CRTKey";
	/***/
	public static final String tagNo = "tagNo";
	/***/
	public static final String tagType = "tagType";
	/***/
	public static final String source = "source";
	
	/***/
	public static final String transportId = "transportId";
	/***/
	public static final String collect = "collect";
	/***/
	public static final String item = "item";
	/***/
	public static final String unit = "unit";
	/***/
	public static final String scale = "scale";
	/***/
	public static final String modelNo = "modelNo";
	/** 转换端口 **/
	public static final String convertNo = "convertNo";
	/** 通道口 **/
	public static final String channelNo = "channelNo";
	/***/
	public static final String type = "type";
	/** 默认值 **/
	public static final String defaultVal = "defaultVal";
	/***/
	public static final String rangeMin = "rangeMin";
	/***/
	public static final String rangeMax = "rangeMax";
	/***/
	public static final String thresholdMin = "thresholdMin";
	/***/
	public static final String thresholdMax = "thresholdMax";
	
	/***/
	public static final String video = "video";
	/***/
	public static final String ip = "ip";
	/***/
	public static final String port = "port";
	/***/
	public static final String account = "account";
	/***/
	public static final String password = "password";
	/***/
	public static final String channel = "channel";
	/**描述信息 **/
	public static final String infoRemark = "infoRemark";
	/** 设备运行状态  **/
	public static final String runStatus = "runStatus";
	/** 设备开关运行状态  **/
	public static final String switchState = "switchState";
	
	/** 电流**/
	public static final String current = "current";
	/** 温度**/
	public static final String temperature = "temperature";
	/** 状态更 新时间**/
	public static final String runTime = "runTime";
	
	public static final String createTime = "createTime";
	public static final String updateTime = "updateTime";
	
	/** 消防泵的作用区域建筑*/
	public static final String areaBuildIds = "areaBuildIds";

	/**
	 * 园区编号/名称
	 */
	public static final String parkId = "parkId";
	public static final String parkName = "parkName";
	/**
	 * 区号/房间号
	 */
	public static final String partitionNo = "partitionNo";
	public static final String partitionName = "partitionName";

	//设备编号及转换成10进制的数字
	public static final String equipNo = "equipNo";
	public static final String equipNoInt = "equipNoInt";
	//bim 模型坐标
	public static final String bimX = "bimX";
	public static final String bimY = "bimY";
	public static final String bimZ = "bimZ";
	
	/**设备编号**/
	public static final String deviceNum = "deviceNum";

	public static String getRefKey(String trspId,String sysAddr,String controllerNo,
			String areaNo,String placeNo){
		if(trspId == null) trspId = "";
		if(sysAddr == null) sysAddr = "";
		if(controllerNo == null) controllerNo = "";
		if(areaNo == null) areaNo = "";
		if(placeNo == null) placeNo = "";
		return DigestUtils.md5Hex(trspId + "-" + sysAddr + "-" + controllerNo + "-" + areaNo + "-" + placeNo);
	}
}