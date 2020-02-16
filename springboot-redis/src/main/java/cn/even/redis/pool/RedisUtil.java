package cn.even.redis.pool;

import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * <p>
 * 描述: Redis连接池类
 * </p>
 * @author  ipark123@163.com
 * @date 2020-02-16
 * @version 1.0.0
 */
public class RedisUtil {

    /**
     * 服务器IP地址
     */
    private final static String HOST = "192.168.8.128";

    /**
     * 端口
     */
    private final static int PORT = 6379;

//    /**
//     * 密码
//     */
    //private static String AUTH = "123456";

    /**
     * 连接实例的最大连接数
     */
    private final static int MAX_ACTIVE = 1024;

    /**
     * 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
     */
    private final static int MAX_IDLE = 32;

    /**
     * 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException
     */
    private final static int MAX_WAIT = 10000;

    /**
     * 连接超时的时间
     */
    private final static int TIMEOUT = 10000;

    /**
     * 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
     */
    private final static boolean TEST_ON_BORROW = true;

    /**
     * 连接池
     */
    private static volatile JedisPool jedisPool = null;

    /**
     * 从池中返回 Jedis 实例
     *
     * @return Jedis实例
     */
    public synchronized static Jedis getJedisInstance() {
        return getJedisInstance(HOST, PORT, null);
    }


    /**
     * 从池中返回 Jedis 实例
     *
     * @param port 端口
     * @return Jedis实例
     */
    public synchronized static Jedis getJedisInstance(Integer port) {
        return getJedisInstance(HOST, port, null);
    }


    /**
     * 从池中返回 Jedis 实例
     *
     * @param host 主机地址
     * @return Jedis实例
     */
    public synchronized static Jedis getJedisInstance(String host) {
        return getJedisInstance(host, PORT, null);
    }


    /**
     * 从池中返回 Jedis 实例
     *
     * @param host 主机
     * @param port 端口
     * @return Jedis实例
     */
    public synchronized static Jedis getJedisInstance(String host, Integer port, String password) {
        if (jedisPool == null) {
            synchronized (RedisUtil.class) {
                if (jedisPool == null) {
                    JedisPoolConfig config = new JedisPoolConfig();
                    config.setMaxTotal(MAX_ACTIVE);
                    config.setMaxIdle(MAX_IDLE);
                    config.setMaxWaitMillis(MAX_WAIT);
                    config.setTestOnBorrow(TEST_ON_BORROW);
                    if (StringUtils.isEmpty(host)) {
                        host = HOST;
                    }
                    if (port == null) {
                        port = PORT;
                    }
                    if (StringUtils.isNotEmpty(password)) {
                        jedisPool = new JedisPool(config, host, port, TIMEOUT, password);
                    } else {
                        jedisPool = new JedisPool(config, host, port, TIMEOUT);
                    }

                }
            }
        }
        return jedisPool.getResource();
    }

    /***
     *
     * 释放资源
     */

    public static void release(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}