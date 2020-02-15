package cn.even.redis;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 描述: 测试常见的redis命令
 * </p>
 *
 * @author ipark123@163.com
 * @version 1.0.0
 * @date 2020-02-15
 */
public class BasicCommandTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.8.128", 6379);

        String result = "";
        Long time;

        //boolean existsKey = jedis.exists("k1");//是否存在key
        //System.out.println(existsKey);

        //List<String> list = jedis.configGet("*"); //获取配置名称，支持正则表达式
        //System.out.println(list);

        //String result = jedis.configSet("", "");//设置配置的值
        //System.out.println(result);

        //jedis.shutdown();//关闭数据库
        //jedis.select(1);//切换数据库,默认有16个库，下标从0至15

        //Long dbSize = jedis.dbSize();//返回当前库key的数量
        //System.out.println(dbSize);

        //Set<String> keys = jedis.keys("*");//根据正则表达式获得匹配的key
        //System.out.println(keys);

        //result = jedis.type("k2");//判断key的类型
        //System.out.println(result);

        //time = jedis.expire("k2", 500);//为指定key设定过期时间：单位秒
        //System.out.println(time);

        //time = jedis.ttl("k2");//查看key的过期时间(单位秒)：-1表示永不过期，-2表示已过期
        //System.out.println(time);

        //jedis.flushDB();//清空当前库
        //jedis.flushAll();//清空整个 Redis 服务器的数据(删除所有数据库的所有 key )

        // result=jedis.info();
        // System.out.println(result);

        //result = jedis.info("memory");//返回关于 Redis 服务器的各种信息和统计数值。
        //server : 一般 Redis 服务器信息;     clients : 已连接客户端信息;
        //memory : 内存信息，包含以下域;      persistence： RDB 和 AOF 的相关信息;
        //stats : 一般统计信息;               replication : 主/从复制信息;
        //cpu : CPU 计算量统计信息;           commandstats : Redis 命令统计信息;
        //cluster : Redis 集群信息;           keyspace : 数据库相关的统计信息;
        //System.out.println(result);

        //jedis.configResetStat();//配置信息重置

        jedis.close();//关闭redis连接
        //jedis.quit();//关闭与redis的连接
    }
}
