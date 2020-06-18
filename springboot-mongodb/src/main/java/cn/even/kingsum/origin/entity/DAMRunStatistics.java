package cn.even.kingsum.origin.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import cn.even.kingsum.origin.util.DateTools;

public class DAMRunStatistics {

	public static final String collName = "dam_run_statistics";

	/**id*/
	public static final String _id = "_id";
	/**统计的日期 例如:ISODate("2016-09-04T16:00:00.000+0000")*/
	public static final String statisticsDate = "statisticsDate";
	/**业主id*/
	public static final String unitId = "unitId";
	/** 用户传输装置里面的source地址 */
	public static final String trspId = "trspId";
	/** 转换口号int */
	public static final String convertNo = "convertNo";
	/** 通道号int */
	public static final String channelNo = "channelNo";
	/** 与设备表关联外键 */
	public static final String refKey = "refKey";
	/** 按小时统计 采用数组形式0~23共24个小时,初始化24小时全是0 */
	public static final String hoursStatistic = "hoursStatistic";
	
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
	 * @param channelNo		通道号
	 * @param occurTime		报警时间
	 * @return	Document
	 */
	public static Document getInitInsert(String trspId,Integer convertNo,Integer channelNo,Date occurTime){
		Calendar cal = Calendar.getInstance();
		cal.setTime(occurTime);
		
		Document insert = new Document(_id,new ObjectId())
				.append(DAMRunStatistics.trspId, trspId)
				.append(DAMRunStatistics.convertNo, convertNo)
				.append(DAMRunStatistics.statisticsDate,DateTools.getTimesmorning())
				.append(DAMRunStatistics.channelNo, channelNo)
				.append(DAMRunStatistics.refKey, trspId==null ? "":trspId + "-" + (convertNo==null?"":convertNo) + "-" + (channelNo==null?"":channelNo))
				.append(DAMRunStatistics.hoursStatistic, initHoursCount(cal.get(Calendar.HOUR_OF_DAY)));
		return insert;
	}
	
}
