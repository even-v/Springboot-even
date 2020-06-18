package cn.even.kingsum.origin.entity;

/**
 * 各个责任人的巡查计划信息
 * @author Administrator
 *
 */
public class FirePatrolPlanUser {

	public static final String collName = "fire_patrol_plan_user";

	/**id*/
	public static final String _id = "_id";
	/**业主id*/
	public static final String unitId = "unitId";
	//计划类型，年、李、月、周、日
	public static final String cycleType = "cycleType";
	//巡查开始时间
	public static final String startDate = "startDate";
	//巡查结束时间
	public static final String endDate = "endDate";
	//生成时间
	public static final String createTime = "createTime";
	//修改时间
	public static final String updateTime = "updateTime";
}