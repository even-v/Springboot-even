package cn.even.redis;


import redis.clients.jedis.Jedis;

/**
 * <p>
 * 描述:JedisCommands接口中关于String的操作方法练习。
 *
 * Redis 字符串数据类型的相关命令用于管理 redis 字符串值。
 * </p>
 * @author  ipark123@163.com
 * @date 2020-02-16
 * @version 1.0.0
 */
public class JedisCommandsStringTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.8.128", 6379);
        String stringResult = "";
        Long longResult=-777L;

        /***************** 字符串操作(start) *****************/

        //stringResult=jedis.set("k1","v1");//设置key的值

        //stringResult= jedis.set("k1","v5","NX");//当key不存在时设置key的值，若key存在返回null

        //设置key的值，nxxx的值只能取NX或者XX，如果取NX，则只有当key不存在是才进行set，如果取XX，则只有当key已经存在时才进行set
        //expx的值只能取EX或者PX，代表数据过期时间的单位，EX代表秒，PX代表毫秒。
        //stringResult=jedis.set("k2","v2","XX","EX",20);

        //stringResult= jedis.get("k3");//获取指定key的值

        //longResult= jedis.setrange("k3",2,"vv3");//用指定的字符串覆盖给定 key 所储存的字符串值，覆盖的位置从偏移量 offset 开始。

        //jedis.getrange("k3",2,4);//获得指定key从startOffset至endOffSet的值(闭区间);0,-1表示全取

        //stringResult=jedis.getSet("k3","v33");//设置并返回指定key的值

        //longResult= jedis.setnx("k3","v3");//只有在 key 不存在时设置 key 的值。成功返回1，失败返回0

        //stringResult =jedis.setex("k3",200,"v3");//若key存在，将值 value 关联到 key ，并将 key 的过期时间设为 seconds (以秒为单位)。

        //longResult= jedis.decrBy("k1",5);//key减少，减少数为v；返回key的值，若key不存在则设置新增key并设值为0
        longResult=jedis.decr("k2");//key自减1；返回key的值，若key不存在则设置新增key并设值为0

        //longResult=jedis.incr("k4");//key自增1；返回key的值，若key不存在则设置新增key并设值为0
        //longResult=jedis.incrBy("k5",5);//key增加，增加数为v；返回key的值，若key不存在则设置新增key并设值为0
        //System.out.println(jedis.incrByFloat("k6",3.456));////key增加小数(可以为负数表示减少)，增加数为v；返回key的值，若key不存在则设置新增key并设值为0

        //longResult=jedis.append("k3","123");//追加新字符串值key后，若key不存在则新建key

        //stringResult=jedis.substr("k3",1,2);//返回key指定范围的子串(闭区间)

        /***************** 字符串操作(end) *****************/
        jedis.close();//关闭redis连接

        System.out.println("stringResult="+stringResult);
        System.out.println("longResult="+longResult);

    }
}


