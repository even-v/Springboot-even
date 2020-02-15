package cn.even.redis;


import redis.clients.jedis.Jedis;

/**
 * <p>
 * 描述: java连接redis测试
 * </p>
 *
 * @author ipark123@163.com
 * @version 1.0.0
 * @date 2020-02-15
 */
public class PingRedis {

    public static void main(String[] args) {
        //192.168.8.128

        //连接Redis，host默认为localhost，port默认为6379
        Jedis jedis = new Jedis("192.168.8.128", 6379);

        //问题一：redis.clients.jedis.exceptions.JedisConnectionException: java.net.SocketTimeoutException: connect timed out
        //问题一原因及解决方案：可能是防火墙拒绝该端口的访问，解决方案设置防火墙规则可以通过该端口访问

        //问题二：DENIED Redis is running in protected mode because protected mode is enabled,
        // no bind address was specified, no authentication password is requested to clients.
        // In this mode connections are only accepted from the loopback interface.
        // If you want to connect from external computers to Redis you may adopt one of the following solutions: 1)
        // Just disable protected mode sending the command 'CONFIG SET protected-mode no' from the loopback interface by
        // connecting to Redis from the same host the server is running,
        // however MAKE SURE Redis is not publicly accessible from internet if you do so.
        // Use CONFIG REWRITE to make this change permanent. 2)
        // Alternatively you can just disable the protected mode by editing the Redis configuration file,
        // and setting the protected mode option to 'no', and then restarting the server. 3)
        // If you started the server manually just for testing, restart it with the '--protected-mode no' option. 4)
        // Setup a bind address or an authentication password. NOTE:
        // You only need to do one of the above things in order for the server to start accepting connections from the outside.

        //问题二原因及解决方案：protected-mode 属性值默认为yes(不允许外部访问)，
        // 使用CONFIG SET protected-mode no修改属性值(仅一次，想要永久修改请修改配置文件：protected-mode设为no；注释掉bind 127.0.0.1)

        //测试ping，成功返回PONG
        System.out.println(jedis.ping());
    }

}
