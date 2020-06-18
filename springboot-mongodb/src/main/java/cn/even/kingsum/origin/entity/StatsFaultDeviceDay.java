package cn.even.kingsum.origin.entity;
import java.util.ArrayList;
import java.util.Date;

import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * 用户设备故障率统计，每天生成一条数据
 * @author wanggq
 * 2017年1月10日
 */
public class StatsFaultDeviceDay {

	public static final String collName = "stats_fault_device_day";

	/** 主键 */
	public static final String _id = "_id";
	/** 业主id */
	public static final String unitId = "unitId";
	/** 总设备数 */
	public static final String deviceCount = "deviceCount";
	/** 设备数组,存refKey,更新时用addToSet */
	public static final String deviceArr = "deviceArr";
	/** 待处理设备数组,存refKey,更新时用addToSet */
	public static final String pendingDeviceArr = "pendingDeviceArr";
	/**统计的日期 例如:ISODate("2016-09-04T16:00:00.000+0000")*/
	public static final String statisticsDate = "statisticsDate";
	
	public static Document getInitInsert(ObjectId unitId,Integer deviceCount,Date statisticsDate){
		return new Document(_id,new ObjectId())
				.append(StatsFaultDeviceDay.unitId, unitId)
				.append(StatsFaultDeviceDay.deviceCount, deviceCount)
				.append(deviceArr, new ArrayList<>())
				.append(pendingDeviceArr, new ArrayList<>())
				.append(StatsFaultDeviceDay.statisticsDate, statisticsDate);
	}
}
