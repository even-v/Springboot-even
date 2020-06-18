//package cn.even.kingsum.origin.util;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import com.kingsum.platform.common.bean.FaultInfo;
//import com.kingsum.platform.common.enums.AlertTypeEnum;
//
//import java.util.Map;
//
//@Component
//public class PushUtil {
//
//	@Value("${push.service.url}")
//	private String pushUrl;
//	@Value("${push.service.common.url}")
//	private String pushCommonUrl;
//
//	public void messagePush(Object doc) {
//		StringBuffer sbf = new StringBuffer();
//		String unitId = "";
//		Integer alertType = 0;
//		String deviceId = "";
//		// [园区][建筑物或区域][楼层][安装位置][设备名称]。
//		if (doc instanceof FaultInfo) {
//			FaultInfo fault = (FaultInfo) doc;
//			unitId = fault.getUnitId().toString();
//			deviceId = fault.getDeviceId().toString();
//			alertType = AlertTypeEnum.alertType500.getIndex();
//			sbf.append("content=").append(fault.getParkName());
//			// 推送隐患信息
//			sbf.append(fault.getBuildingName()).append(fault.getFloorName()).append(fault.getPlace())
//					.append(fault.getDeviceName());
//		}
//
//		sbf.append("&unitId").append(unitId).append("&alertType=").append(alertType).append("&deviceId=")
//				.append(deviceId);
//		HttpUtil.sendPost(pushUrl, sbf.toString());
//	}
//
//	/**
//	 *
//	 * @param paramMap
//	 */
//	public void messagePush(Map<String,String> paramMap) {
//		String smsParam = SystemUtil.mapToUrl(paramMap);
//		HttpUtil.sendPost(pushCommonUrl, smsParam);
//	}
//}
