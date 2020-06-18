package cn.even.kingsum.origin.entity;

/**
 * 视频设备异常统计
 * 
 * @author Administrator
 *
 */
public class IotVideoAnalysis {

	public static final String collName = "iot_video_analysis";

	/***/
	public static final String _id = "_id";

	/** 业主名称 */
	public static final String orgName = "orgName";

	/** 业主Id */
	public static final String unitId = "unitId";
	
	/** 设备失联次数 */
	public static final String lostTotal = "lostTotal";

	/** 统计时间  */
	public static final String receiveDate = "receiveDate";
	
}