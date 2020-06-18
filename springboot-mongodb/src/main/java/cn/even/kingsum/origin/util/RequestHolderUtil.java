//package cn.even.kingsum.origin.util;
//
//import java.util.List;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.util.StringUtils;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//import org.springframework.web.util.WebUtils;
//
//import com.alibaba.fastjson.JSON;
//import com.kingsum.platform.common.bean.PlatformRole;
//import com.kingsum.platform.common.bean.PlatformUser;
//import com.kingsum.platform.common.core.Constants;
//
//public class RequestHolderUtil {
//
//
//	/**
//	 * Get Request from org.springframework.web.context.request.RequestContextHolder
//	 * RequestContextHolder需要配置在web.xml的过滤器中
//	 * 注意不能获得上传文件的Request
//	 * @return HttpServletRequest
//	 */
//	public static HttpServletRequest getRequest(){
//		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
//		return request;
//	}
//
//	public static HttpServletResponse getResponse(){
//		HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
//		return response;
//
//	}
//
//	/**
//	 * 获得用户身份对对象
//	 * @return PlatformUser
//	 */
//	public static PlatformUser getSessionUser(){
//		String jssionid = getMyToken();//类似token
//		PlatformUser user = null;
//		if(jssionid==null)
//			return null;
//
//		user = getUserByToken(jssionid);
//
//		//return (PlatformUser)getRequest().getSession().getAttribute(Constants.SESSION_KEY);
//		return getCrossLoginUser(user);
//
//	}
//
//	public static String getMyToken(){
//		Cookie rememberCookie = WebUtils.getCookie(getRequest(), Constants.REMEMBERME_COOKIE);
//    	if(rememberCookie == null){
//    		return null;
//    	}
//    	String[] userArr = SecurityUtil.decodeRememberToken(rememberCookie.getValue());
//    	if(userArr.length != 4 ){
//    		return null;
//    	}
//		String jssionid = userArr[2];//类似token
//		return jssionid;
//	}
//
//	public static PlatformUser getUserByToken(String token){
//		String userJson = CacheUtils.getStr(token);
//		PlatformUser user = JSON.parseObject(userJson, PlatformUser.class);
//		return user;
//	}
//
//	//获得前缀
//	public static String getAgentKeyType(String userAgent){
//			if(StringUtils.isEmpty(userAgent))
//				return null;
//
//			// windows mac
//			if(userAgent.contains(Constants.PC_AGENT_WINDOWS)||userAgent.contains(Constants.PC_AGENT_MAC)){
//				return Constants.PC_KEY_START;
//			}
//
//			// android
//			if(userAgent.contains(Constants.M_AGENT_ANDROID)){
//				return Constants.M_KEY_START;
//			}
//			//ios mobile
//			for(int i=0;i<Constants.M_AGENT_IPHONE.length;i++){
//				if(userAgent.toLowerCase().contains(Constants.M_AGENT_IPHONE[i])){
//					return Constants.M_KEY_START;
//				}
//			}
//			return null;
//	}
//
//	private static PlatformUser getCrossLoginUser(PlatformUser user){
//		String systemId = RequestHolderUtil.getRequest().getParameter("systemId");
//		if(user !=null){
//			if(!StringUtils.isEmpty(systemId)){
//				if(user.getSysType()!=Integer.valueOf(systemId)){
//					if(Integer.valueOf(systemId)==5&&user.getSysType()!=Integer.valueOf(systemId)){//访问业主端的
//						String[] userArr2 = decodeUserAccountAndPasswordByCookieToken(RequestHolderUtil.getRequest(),Constants.CROSS_UNIT);
//						if(userArr2 !=null){
//
//							String jssionid2 = userArr2[2];
//							String userJson2 = CacheUtils.getStr(jssionid2);//验证是否有效
//							if(userJson2 !=null){
//								PlatformUser user2 = JSON.parseObject(userJson2, PlatformUser.class);
//								List<PlatformRole> roles = user2.getRoles();
//								user.setRoles(roles);
//								user.setOrgId(user2.getOrgId());
//								user.setSysType(user2.getSysType());
//								user.setIsSysType(user2.getSysType());
//								user.setOrgName(user2.getOrgName());
//								user.setShortName(user2.getShortName());
//								user.setOrgType(user2.getOrgType());
//								user.setOrgPic(user2.getOrgPic());
//							}
//
//						}
//					}
//				}
//			}
//		}
//		return user;
//	}
//
//	private static String[] decodeUserAccountAndPasswordByCookieToken(HttpServletRequest req,String cookieType) {
//		Cookie rememberCookie = WebUtils.getCookie(req, cookieType);
//		if (rememberCookie == null) {
//			return null;
//		}
//		String[] userArr = SecurityUtil.decodeRememberToken(rememberCookie.getValue());
//		if (userArr.length != 4) {
//			return null;
//		}
//		return userArr;
//
//	}
//
//}
