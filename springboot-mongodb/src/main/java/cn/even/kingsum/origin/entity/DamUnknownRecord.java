package cn.even.kingsum.origin.entity;

/**
 * 监测上传数据未关联到传输装置后保存记录日志表
 * @author Administrator
 *
 */
public class DamUnknownRecord{

	public static final String collName = "dam_unknown_record";

	/***/
	public static final String _id = "_id";
	/** 传输装置ID **/
	public static final String transportId = "transportId";
	/** 转换器地址编号 **/
	public static final String convertNo = "convertNo";
	/** 转换器端口号 **/
	public static final String channelNo = "channelNo";
	/** 上传的原始数据 **/
	public static final String sourceData = "sourceData";
	/** 上传记录IP **/
	public static final String host = "host";
	/** 上传记录的端口 **/
	public static final String port = "port";
	/** 上传记录时间 **/
	public static final String createTime = "createTime";
	
}