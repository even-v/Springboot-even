//package cn.even.kingsum.origin.util;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class PushServiceUtil {
//
//	static Logger LOGGER = LoggerFactory.getLogger(PushUtil.class);
//
//	private static String pushUrl;
//
//	public static String getPushUrl() {
//		return pushUrl;
//	}
//
//	public static void setPushUrl(String pushUrl) {
//		PushServiceUtil.pushUrl = pushUrl;
//	}
//
//	public static void send(String pra) {
//		HttpUtil.sendPost(pushUrl, pra);
//	}
//
//	/**
//	 * 消息推送
//	 *
//	 * @param json
//	 */
//	public void pushMessage(String data) {
//		HttpUtil.sendPost(pushUrl, data);
//	}
//
//	public static void main(String[] args) {
//		String smsusl = "http://sms.kingsum.biz:91/api/producer/messageSend.do";
//		String pra = "content=虹桥天地园区F栋地址号3回路号122的无限烟感11&unitId=59648017ebc56e3a99bc33b5&alertType=100&deviceId=59f0029c6045ec18ac2bf374";
//		domeSend(smsusl, pra);
//
//	}
//
//	static void domeSend(String smsusl, String pra) {
//		HttpUtil.sendPost(smsusl, pra);
//	}
//
//}
