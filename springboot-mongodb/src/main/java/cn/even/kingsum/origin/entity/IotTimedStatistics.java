package cn.even.kingsum.origin.entity;

public class IotTimedStatistics{

	public static final String collName = "iot_timed_statistics";

	/**主键*/
	public static final String _id = "_id";
	/** 业主id**/
	public static final String unitId = "unitId";
	/** 统计类别 **/
	public static final String runStatus = "statsType";
	/** 统计火警日平均处理时间**/
	public static final String respTime = "respTime";
	
	/** 统计开始日期 **/
	public static final String startDate = "startDate";
	/** 统计结束日期 **/
	public static final String endDate = "endDate";
	
	/** 创建日期 **/
	public static final String date = "date";
	/** 总条数**/
	public static final String count = "count";
	/***/
	public static final String qita = "qita";
}