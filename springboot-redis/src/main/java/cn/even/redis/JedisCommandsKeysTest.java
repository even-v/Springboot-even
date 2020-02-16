package cn.even.redis;


import redis.clients.jedis.Jedis;

/**
 * <p>
 * 描述: JedisCommands接口中关于key的操作方法练习。
 *
 * Redis 键命令用于管理 redis 的键。
 * </p>
 * @author  ipark123@163.com
 * @date 2020-02-16
 * @version 1.0.0
 */
public class JedisCommandsKeysTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.8.128", 6379);
        String stringResult = "";
        Long longResult=-777L;

        /***************** key操作(start) *****************/

        //longResult= jedis.persist("k3");//命令用于移除给定 key 的过期时间，使得 key 永不过期。当过期时间移除成功时，返回 1 。 如果 key 不存在或 key 没有设置过期时间，返回 0 。

        //longResult=jedis.expire("key",200);//设置指定key的过期时间(单位秒)。设置成功返回 1 。 当 key 不存在或者不能为 key 设置过期时间时(比如在低于 2.1.3 版本的 Redis 中你尝试更新 key 的过期时间)返回 0 。

        //jedis.expireAt("key",2000);//命令用于以 UNIX 时间戳(unix timestamp)格式设置 key 的过期时间

        //longResult=jedis.ttl("k9");//查看指定key的过期时间(单位秒)
        //longResult= jedis.pttl("k9");//查看key过期时间(单位毫秒)

        /***************** key操作(end) *****************/
        jedis.close();//关闭redis连接

        System.out.println("stringResult="+stringResult);
        System.out.println("longResult="+longResult);

    }
}


