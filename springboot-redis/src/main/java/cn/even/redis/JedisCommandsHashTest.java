package cn.even.redis;


import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * <p>
 * 描述:JedisCommands接口中关于Hash的操作方法练习。
 *
 * Redis hash 是一个 string 类型的 field 和 value 的映射表，hash 特别适合用于存储对象。
 *
 * Redis 中每个 hash 可以存储 232 - 1 键值对（40多亿）。
 * </p>
 * @author  ipark123@163.com
 * @date 2020-02-16
 * @version 1.0.0
 */
public class JedisCommandsHashTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.8.128", 6379);
        String stringResult = "";
        Long longResult=-777L;
        List<String> listResult=new ArrayList<>();
        Set<String> setResult=new HashSet<>();
        Map<String,String> mapResult=new HashMap<>();

        /***************** 哈希操作(start) *****************/

        //longResult= jedis.hset("hUser","username","admin");//设置指定hash域的值，hash不存在或域不存在则新建hash新建域

        //stringResult= jedis.hget("hUser","username");//获取指定hash的域的值

        //longResult=jedis.hsetnx("hUser","password","pwd");//只有在域field不存在时，设置哈希表字段的值。设置成功，返回 1 。 如果给定字段已经存在且没有操作被执行，返回 0 。

        //Map<String,String> map=new HashMap<>();
        //map.put("email","ipark123@163.com");
        //map.put("phone","15371364266");
        //stringResult=jedis.hmset("hUser",map);//同时将多个 field-value (域-值)对设置到哈希表 key 中。若key不存在则新建key

        //listResult=jedis.hmget("hUser","email","phone","des");//获取执行key的多个域的值，若域不存在返回null。值不存在则全为null

        //longResult=jedis.hincrBy("hUser","num",3);//对指定key指定域的值增加整数value。若key不存在新建key，域不存在新建域
        //jedis.hincrByFloat("hUser","num",3.14);//对指定key指定域的值增加小数value。若key不存在新建key，域不存在新建域

        //jedis.hexists("hUser","field");//验证指定hash指定域是否存在，返回布尔值

        //longResult=jedis.hdel("hUser","field");//删除指定hash指定域，存在且删除成功返回1，否则返回0

        //longResult=jedis.hlen("hUser");//返回hash中key的个数

        //setResult=jedis.hkeys("hUser");//返回hash中的所有域名(Set)

        //listResult=jedis.hvals("hUser");//返回hash中的所有域对应的值

        //mapResult=jedis.hgetAll("hUser");//返回所有hash中所有的 域-值 对

        /***************** 哈希操作(end) *****************/
        jedis.close();//关闭redis连接

        System.out.println("stringResult"+stringResult);
        System.out.println("longResult"+longResult);
        System.out.println("listResult"+listResult);
        System.out.println("setResult"+setResult);
        System.out.println("mapResult"+mapResult);
    }
}


