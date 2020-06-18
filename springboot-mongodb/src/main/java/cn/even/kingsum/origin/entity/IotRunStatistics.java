package cn.even.kingsum.origin.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import cn.even.kingsum.origin.util.DateTools;

public class IotRunStatistics {

	public static final String collName = "iot_run_statistics";

	/**id*/
	public static final String _id = "_id";
	/**统计的日期 例如:ISODate("2016-09-04T16:00:00.000+0000")*/
	public static final String statisticsDate = "statisticsDate";
	/**业主id*/
	public static final String unitId = "unitId";
	/** 用户传输装置里面的source地址 */
	public static final String trspId = "trspId";
	/** 系统地址 */
	public static final String sysAddr = "sysAddr";
	/** 部件地址 */
	public static final String compAddr = "compAddr";
	/** 与设备表关联外键  */
	public static final String refKey = "refKey";
	
	/** 报警统计 */
	public static final String alarmStatistic = "alarmStatistic";
	/** 报警类型 */
	public static final String alarmType = "alarmType";
	/** 此类型报警数量 */
	public static final String alarmCount = "alarmCount";
	/** 按小时统计 采用数组形式0~23共24个小时,初始化24小时全是0 */
	public static final String hoursCount = "hoursCount";
	/** 按小时统计未处理状态的数据 采用数组形式0~23共24个小时,初始化24小时全是0 */
	public static final String pendingHoursCount = "pendingHoursCount";
	
	/** 处理结果统计 */
	public static final String dealRetStatistic = "dealRetStatistic";
	/** 处理结果为真实的火警数 */
	public static final String realFireCount = "realFireCount";
	/** 处理结果为测试的火警数 */
	public static final String testFireCount = "testFireCount";
	/** 处理结果为误报的火警数 */
	public static final String misFireCount = "misFireCount";
	/** 处理结果为故障的数量 */
	public static final String faultFireCount = "faultFireCount";
	/** 处理结果为删除的数量 */
	public static final String delCount = "delCount";
	/** 处理结果为其他的数量 */
	public static final String otherCount = "otherCount";
	
	
	/**
	 * 获取初始化的小时统计数组
	 * @return
	 */
	public static List<Integer> initHoursCount(Integer hour){
		List<Integer> hoursArr = new ArrayList<>();
		for(int i = 0;i<24;i++){
			if(hour == i){
				hoursArr.add(1);
			}else{
				hoursArr.add(0);
			}
		}
		return hoursArr;
	}
	
	/**
	 * 获取初始化插入document
	 * @param trspId		传输装置id
	 * @param sysAddr		系统端口
	 * @param alarmType		报警类型
	 * @param occurTime		报警时间
	 * @return	document
	 */
	public static Document getInitInsert(String trspId,String sysAddr,String alarmType,Date occurTime,String compAddr){
		Calendar cal = Calendar.getInstance();
		cal.setTime(occurTime);
		
		Document alarmStatisticDoc = initAlarmStatisticDoc(occurTime,alarmType);
		
		Document dealRetStatisticDoc = new Document(realFireCount,0).append(testFireCount, 0).append(misFireCount, 0)
				.append(faultFireCount, 0).append(faultFireCount, 0).append(delCount, 0).append(otherCount, 0);
		
		Document insert = new Document(IotRunStatistics._id,new ObjectId())
				.append(IotRunStatistics.trspId, trspId)
				.append(IotRunStatistics.sysAddr, sysAddr)
				.append(IotRunStatistics.compAddr, compAddr)
				.append(IotRunStatistics.refKey, trspId==null ? "":trspId + "-" + (sysAddr==null?"":sysAddr) + "-" + (compAddr==null?"":compAddr))
				.append(IotRunStatistics.statisticsDate,DateTools.getTimesmorning())
				.append(alarmStatistic, Arrays.asList(alarmStatisticDoc))
				.append(dealRetStatistic, dealRetStatisticDoc)
				;
		return insert;
	}
	
	public static Document initAlarmStatisticDoc(Date occurTime,String alarmType){
		Calendar cal = Calendar.getInstance();
		cal.setTime(occurTime);
		return new Document(IotRunStatistics.alarmType, alarmType)
				.append(IotRunStatistics.alarmCount, 1)
				.append(IotRunStatistics.hoursCount, initHoursCount(cal.get(Calendar.HOUR_OF_DAY)))
				.append(IotRunStatistics.pendingHoursCount, initHoursCount(cal.get(Calendar.HOUR_OF_DAY)));
	}
	
}
