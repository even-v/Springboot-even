//package cn.even.kingsum.origin.util;
//
//
//import org.springframework.util.StringUtils;
//
//import com.kingsum.platform.common.core.Constants;
//
//
//public final class UserAgentUtil {
//
//
//	//获得前缀
//	public static String getAgentKeyType(String userAgent){
//		if(StringUtils.isEmpty(userAgent))
//			return null;
//
//		// windows mac
//		if(userAgent.contains(Constants.PC_AGENT_WINDOWS)||userAgent.contains(Constants.PC_AGENT_MAC)){
//			return Constants.PC_KEY_START;
//		}
//
//		// android
//		if(userAgent.contains(Constants.M_AGENT_ANDROID)){
//			return Constants.M_KEY_START;
//		}
//		//ios mobile
//		for(int i=0;i<Constants.M_AGENT_IPHONE.length;i++){
//			if(userAgent.toLowerCase().contains(Constants.M_AGENT_IPHONE[i])){
//				return Constants.M_KEY_START;
//			}
//		}
//		return null;
//	}
//
//}