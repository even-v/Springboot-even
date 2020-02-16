package cn.even.redis;


import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * <p>
 * 描述:JedisCommands接口中关于Set的操作方法练习。
 *
 * Redis 的 Set 是 String 类型的无序集合。集合成员是唯一的，这就意味着集合中不能出现重复的数据。
 *
 * Redis 中集合是通过哈希表实现的，所以添加，删除，查找的复杂度都是 O(1)。
 *
 * 集合中最大的成员数为 232 - 1 (4294967295, 每个集合可存储40多亿个成员)。
 * </p>
 * @author  ipark123@163.com
 * @date 2020-02-16
 * @version 1.0.0
 */
public class JedisCommandsSetTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.8.128", 6379);
        String stringResult = "";
        Long longResult=-777L;
        List<String> listResult=new ArrayList<>();
        Set<String> setResult=new HashSet<>();


        /***************** Set操作(start) *****************/
        //longResult=jedis.sadd("sk","sv1","sv2","sv3");//set中加入指定的值，set不存在则新建，value已存在不做更改

        //setResult=jedis.smembers("sk");//获取指定set的成员

        //longResult=jedis.srem("sks","sv1");//移除指定set的指定成员，成功返回1，失败返回0

        //stringResult=jedis.spop("sk");//随机移除set中的成员并返回

        //setResult= jedis.spop("sk",3);//随机移除set中的count个成员并返回

        //longResult=jedis.scard("sk");//获取指定set的成员数

        //jedis.sismember("sk","");//判断 member 元素是否是set 的成员

        //stringResult=jedis.srandmember("sk");//随机返回set中的一个成员

        //listResult=jedis.srandmember("sk",3);//随机返回set中count个成员


        /***************** Set操作(end) *****************/
        jedis.close();//关闭redis连接

        System.out.println("stringResult="+stringResult);
        System.out.println("longResult="+longResult);
        System.out.println("listResult="+listResult);
        System.out.println("setResult="+setResult);

    }
}


