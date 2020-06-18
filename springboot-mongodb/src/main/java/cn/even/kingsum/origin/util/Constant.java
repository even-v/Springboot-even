package cn.even.kingsum.origin.util;


public class Constant {
	
	public interface GB_FIRE_SYS{
		/** 正常运行 */
		public final static  int RUN=0;
		/** 火警 */
		public static final int FIRE=1;
		/** 故障 */
		public static final int FAULT=2;
		/** 屏蔽 */
		public static final int SHEILD=3;
		/** 监管 */ 
		public static final int MONITOR = 4;
		/** 启动状态 */
		public static final int STARTUP = 5;
		/** 反馈 */
		public static final int FEEDBACK = 6;
		/** 延迟 */
		public static final int DELAY = 7;
		/** 主电源 */
		public static final int MPOWER = 8;
		/** 备用电源 */
		public static final int SPOWER = 9;
		/** 总线故障 */
		public static final int BUS_FAULT = 10;
		/** 手动状态 */
		public static final int MANUAL = 11;
		/** 复位 */
		public static final int RESET = 12;
		/** 联动 */
		public static final int LINKAGE = 13;
		/** 巡检 */
		public static final int PORTRAL = 14;
		/** 模块提示 */
		public static final int MODULE_PROMPT = 15;
		/** 配置改变 */
		public static final int CONFIG_CHANGE = 16;
		/** 信道故障 */
		public static final int CHANNEL_FAULT = 17;
		/** 监测线路故障 */
		public static final int MONITOR_LINE_FAULT = 18;
		/** 消音 */
		public static final int SILENCER = 19;
		/** 手动火警故障  | 紧急火警*/
		public static final int MANUAL_FIRE = 20;
		/** 自检 */
		public static final int SELF_CHECK = 21;
		/** 查岗应答 */
		public static final int INSPECT_ANSWER = 22;
		/** 跟踪火警 */
		public final static int FOLLOW_FIRE = 23;
		/** 误报火警 */
		public final static int MIS_FIRE = 24;
		/** 自动火警 */
		public final static int AUTO_FIRE = 25;
		/** 确认火警 */
		public final static int CONFIRM_FIRE = 26;
		/** 测试火警 */
		public final static int TEST_FIRE = 27;
		/** 警情清除 */
		public static final int FIRE_CLEAR = 28;
		/** 确认 */
		public static final int CONFIRM = 29;
		/** 测试 */
		public static final int TEST = 30;
		/** 停止状态 */
		public static final int STOP = 31;
		/** 自动状态 */
		public static final int AUTO=32;
		
	}
	
	public interface HANDEL_RESULT{
		public static final int dealRet_real = 1;//"真实火警"),//处理结果类型 跟踪火警=真实火警
		public static final int dealRet_test = 2;//"测试火警"),//处理结果类型
		public static final int dealRet_mis = 3;//"误报火警"),//处理结果类型
		public static final int dealRet_fault = 4;//"故障信息"),//处理结果类型
		public static final int dealRet_other = 0;//"其他"//处理结果类型
	}
	
	public interface COLLECT_ITEM {
		public static final int OPEN_CLOSE = 50;   //采集门等 打开、关闭状态 : 打开或关闭
		public static final int AUTO_MANUAL = 51;  //采集手动/自动状态: 手动或自动
		public static final int START_STOP = 52;   //采集运行状态 : 已启动或者停止
		
		public static final int HYDRAULIC_PRESSURE = 80; //采集液压
		public static final int LIQUID_LEVEL = 81; //采集液位
		public static final int AIR_PRESSURE = 82; //采集气压
		
		
		public static final int CONTROL = 90; //继电器控制
	}
	
	
	public interface COLLECT_STATUS{
		/** 超过上线 */
		public final static int TOO_HIGHT = 801;
		/** 超过下线 */
		public final static int TOO_LOW = 802;
		/** 正常范围内，正常 */
		public final static int NORMARL = 803;
		
		/** 打开 */
		public final static int OPEN = 501;
		/** 关闭 */
		public final static int CLOSE = 500;
	}
	
	
	public interface MessageType {
		
		public static final String PLATFORM = "00";
		
		public static final String FIRE = "01";
		
		public static final String FAULT = "02";
		
		public static final String SHEILD = "03";
		
	}
	
	public interface OrgType{
		/** 平台自身*/
		public static final Integer PT = 1;
		/** 维保单位 */
		public static final Integer WB = 2;
		/** 社会单位 */
		public static final Integer SH = 3;
		/** 监管单位 */
		public static final Integer JG = 4;
	}

}
