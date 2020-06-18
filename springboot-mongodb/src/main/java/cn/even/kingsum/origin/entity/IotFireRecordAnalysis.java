package cn.even.kingsum.origin.entity;

public class IotFireRecordAnalysis{

	public static final String collName = "iot_fire_record_analysis";

	/***/
	public static final String _id = "_id";
	
	/*
	 * 业主名称
	 */
	public static final String orgName = "orgName";
	
	/*
	 * 业主Id
	 */
	public static final String unitId = "unitId";
	
	/*
	 * 今日时间
	 */
	public static final String receiveDate = "receiveDate";
	
	/*
	 * 火警类型 1消防主机 16电气火灾
	 * **/
	public static final String fireType = "fireType";
	
	/*
	 * 新增火警
	 */
	public static final String newFire = "newFire";
	
	/**
	 * 屏蔽点
	 */
	public static final String sheild = "sheild";
	
	/*
	 * 今日已处理的新增火警（只包括今日新增）
	 */
	public static final String newFireHandle = "newFireHandle";
	
	/*
	 * 今日处理火警总数(包括今日新增和以前的火警)
	 */
	public static final String allFireHandle = "allFireHandle";
	
	/*
	 * 以前未处理的火警（不包括今天）
	 */
	public static final String noHandleOldFire = "noHandleOldFire";
	
	/*
	 * 测试火警
	 */
	public static final String testFire = "testFire";
	
	/*
	 * 真实火警
	 * **/
	public static final String isTrueFire = "isTrueFire";
	
	/*
	 * 误报火警
	 * **/
	public static final String errorFire = "errorFire";
	
	/*
	 * 手动复位
	 * **/
	public static final String resetFire = "resetFire";
	
	
	/*
	 * 以前未处理故障数（不包括今天）
	 */
	public static final String noHandleOldFault = "noHandleOldFault";
	
	/*
	 *今日新增故障总数
	 */
	public static final String newFault = "newFault";
	
	/*
	 *今日处理的新增故障数（只包括今日新增）
	 */
	public static final String newFaultHandle = "newFaultHandle";
	
	/*
	 * 今日处理故障总数 (包括今日新增和以前的故障)
	 */
	public static final String allFaultHandle = "allFaultHandle";
}