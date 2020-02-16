package cn.even.redis.pool;

import redis.clients.jedis.Jedis;

/**
 * <p>
 * 描述: 测试Redis连接池
 * </p>
 *
 * @author ipark123@163.com
 * @version 1.0.0
 * @date 2020-02-16
 */
public class TestRedisUtil {
    public static void main(String[] argd) {
        //从池中获取实例
        Jedis jedis = RedisUtil.getJedisInstance("192.168.8.128");

        //ping
        System.out.println(jedis.ping());

        //释放实例资源
        RedisUtil.release(jedis);
    }
}
