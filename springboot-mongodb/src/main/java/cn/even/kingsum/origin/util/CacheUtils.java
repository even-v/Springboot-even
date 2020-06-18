//package cn.even.kingsum.origin.util;
//
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.util.CollectionUtils;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//
///**
// * 通用缓存工具类
// *
// */
//public class CacheUtils {
//
//	private static RedisTemplate redisTemplate = (RedisTemplate) SpringContextUtil.getBean("redisTemplate");
//
//	/**
//	 * 删除缓存<br>
//	 * 根据key精确匹配删除
//	 *
//	 * @param key
//	 */
//	@SuppressWarnings("unchecked")
//	public static void del(String... key) {
//		if (key != null && key.length > 0) {
//			if (key.length == 1) {
//				redisTemplate.delete(key[0]);
//			} else {
//				redisTemplate.delete(CollectionUtils.arrayToList(key));
//			}
//		}
//	}
//
//	/**
//	 * 批量删除<br>
//	 * （该操作会执行模糊查询，请尽量不要使用，以免影响性能或误删）
//	 *
//	 * @param pattern
//	 */
//	public static void batchDel(String... pattern) {
//		for (String kp : pattern) {
//			redisTemplate.delete(redisTemplate.keys(kp + "*"));
//		}
//	}
//
//	/**
//	 * 获取缓存<br>
//	 * 注：基本数据类型(Character除外)，请直接使用get(String key, Class<T> clazz)取值
//	 *
//	 * @param key
//	 * @return
//	 */
//	public static Object getObj(String key) {
//		return redisTemplate.opsForValue().get(key);
//	}
//
//	public static String getStr(String key) {
//		Object obj = redisTemplate.opsForValue().get(key);
//		if (obj == null) {
//			return null;
//		}
//		return obj.toString();
//	}
//
//	/**
//	 * 获取缓存<br>
//	 * 注：java 8种基本类型的数据请直接使用get(String key, Class<T> clazz)取值
//	 *
//	 * @param key
//	 * @param retain
//	 *            是否保留
//	 * @return
//	 */
//	public static Object getObj(String key, boolean retain) {
//		Object obj = redisTemplate.boundValueOps(key).get();
//		if (!retain) {
//			redisTemplate.delete(key);
//		}
//		return obj;
//	}
//
//	/**
//	 * 获取缓存<br>
//	 * 注：该方法暂不支持Character数据类型
//	 *
//	 * @param key
//	 *            key
//	 * @param clazz
//	 *            类型
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public static <T> T get(String key, Class<T> clazz) {
//		return (T) redisTemplate.boundValueOps(key).get();
//	}
//
//	/**
//	 * 获取缓存json对象<br>
//	 *
//	 * @param key
//	 *            key
//	 * @param clazz
//	 *            类型
//	 * @return
//	 */
//	public static <T> T getJson(String key, Class<T> clazz) {
//		Object obj = redisTemplate.opsForValue().get(key);
//		if (obj == null) {
//			return null;
//		}
//		return JSONObject.parseObject(obj.toString(), clazz);
//	}
//
//	public static JSONArray getJsonArr(String key) {
//		Object obj = redisTemplate.opsForValue().get(key);
//		if (obj == null) {
//			return null;
//		}
//		return JSONArray.parseArray(obj.toString());
//	}
//
//	/**
//	 * 将value对象写入缓存
//	 *
//	 * @param key
//	 * @param value
//	 * @param time
//	 *            失效时间(秒)
//	 */
//	public static void set(String key, Object value, Long time) {
//		redisTemplate.opsForValue().set(key, value.toString());
//		if (time > 0) {
//			redisTemplate.expire(key, time, TimeUnit.SECONDS);
//		}
//	}
//
//	/**
//	 * 将value对象以JSON格式写入缓存
//	 *
//	 * @param key
//	 * @param value
//	 * @param time
//	 *            失效时间(秒)
//	 */
//	public static void setJson(String key, Object value, Long time) {
//		if (value instanceof String) {
//			redisTemplate.opsForValue().set(key, value.toString());
//		} else {
//			redisTemplate.opsForValue().set(key, JSONObject.toJSONString(value));
//		}
//		if (time > 0) {
//			redisTemplate.expire(key, time, TimeUnit.SECONDS);
//		}
//	}
//
//	public static void setJson(String key, Object value) {
//		if (value instanceof String) {
//			redisTemplate.opsForValue().set(key, value);
//		} else {
//			redisTemplate.opsForValue().set(key, JSONObject.toJSONString(value));
//		}
//	}
//
//	/**
//	 * 指定缓存的失效时间
//	 *
//	 * @author FangJun
//	 * @date 2016年8月14日
//	 * @param key
//	 *            缓存KEY
//	 * @param time
//	 *            失效时间(秒)
//	 */
//	public static void setExpire(String key, Long time) {
//		if (time > 0) {
//			redisTemplate.expire(key, time, TimeUnit.SECONDS);
//		}
//	}
//
//	public static void setExpireTimeUnit(String key, Long time, TimeUnit timeType) {
//		if (time > 0) {
//			redisTemplate.expire(key, time, timeType);
//		}
//	}
//
//	/**
//	 * 模糊查询keys
//	 *
//	 * @param pattern
//	 * @return
//	 */
//	public static Set<String> keys(String pattern) {
//		return redisTemplate.keys(pattern);
//	}
//
//}
