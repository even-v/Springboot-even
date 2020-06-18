package cn.even.kingsum.origin.entity;

/**
 * 隐患统计
 * 
 * @author Administrator
 *
 */
public class IotFireFaultAnalysis {

	public static final String collName = "iot_fire_fault_analysis";

	/***/
	public static final String _id = "_id";

	/** 业主名称 */
	public static final String orgName = "orgName";

	/** 业主Id */
	public static final String unitId = "unitId";

	/** 今日时间 */
	public static final String receiveDate = "receiveDate";

	/** 当日新增的隐患 */
	public static final String newFaultTotal = "newFaultTotal";

	/** 今日已处理的隐患 */
	public static final String currentHasHandlingTotal = "currentHasHandlingTotal";

	/** 所有未处理的隐患 */
	public static final String allHasHandlingTotal = "allHasHandlingTotal";
}