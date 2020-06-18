//package cn.even.kingsum.origin.util;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import com.alibaba.fastjson.JSON;
//
//public class ParameterUtil {
//
//	public static <T>  T parseObject(HttpServletRequest request,Class<T> clazz){
//
//		Map<String, String[]> map = request.getParameterMap();
//		Map<String, String> newMap = new HashMap<String, String>();
//
//		for(Map.Entry<String, String[]> entry:map.entrySet()){
//			newMap.put(entry.getKey(), entry.getValue()[0]);
//		}
//
//		String json = JSON.toJSONString(map);
//
//		T t = JSON.parseObject(json, clazz);
//		return t;
//	}
//
//	public static <T> T parseObject(Map<String, String[]> map,Class<T> clazz){
//
//		Map<String, String> newMap = new HashMap<String, String>();
//
//		for(Map.Entry<String, String[]> entry:map.entrySet()){
//			newMap.put(entry.getKey(), entry.getValue()[0]);
//		}
//
//		String json = JSON.toJSONString(newMap);
//
//		T t = JSON.parseObject(json, clazz);
//		return t;
//	}
//
//	public static <T> T parseMap2Object(Map<String, String> map,Class<T> clazz){
//		String json = JSON.toJSONString(map);
//		T t = JSON.parseObject(json, clazz);
//		return t;
//	}
//
//}
