package cn.even.kingsum.origin.entity;

/**
 * 维保工单
 * @author xukx
 *
 */
public class IotWorkOrder {

	public static final String collName = "iot_work_order";

	/***/
	public static final String _id = "_id";
	/** 工单号 **/
	public static final String orderNo = "orderNo";
	/** 隐患编号 **/
	public static final String faultId = "faultId";
	/** 拒绝理由 **/
	public static final String refuseReason = "refuseReason";
	/** 评论级别 **/
	public static final String evaluationLevel = "evaluationLevel";
	/** 评论内容 **/
	public static final String evaluationContent = "evaluationContent";
	/** 评论图片 **/
	public static final String evaluationPic = "evaluationPic";
	/** 维保公司 **/
	public static final String maintainCompany = "maintainCompany";
	/** 维保责任人 **/
	public static final String maintainUser = "maintainUser";
	/** 维保图片 **/
	public static final String maintainTel = "maintainTel";
	/** 工单创建人 **/
	public static final String createUser = "createUser";
	/** 评论图片 **/
	public static final String createTime = "createTime";
	/** 组织编号 **/
	public static final String unitId = "unitId";
	/**
	 * 未整改     1
	 * 待接单	  2
	 * 待上门     3
	 * 维修待确认 4
	 * 已整改	  5
	 **/
	public static final String status = "status";

}