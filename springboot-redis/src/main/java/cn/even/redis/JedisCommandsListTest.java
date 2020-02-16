package cn.even.redis;


import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * <p>
 * 描述:JedisCommands接口中关于List的操作方法练习。
 *
 * Redis列表是简单的字符串列表，按照插入顺序排序。你可以添加一个元素到列表的头部（左边）或者尾部（右边）
 *
 * 一个列表最多可以包含 232 - 1 个元素 (4294967295, 每个列表超过40亿个元素)。
 * </p>
 * @author  ipark123@163.com
 * @date 2020-02-16
 * @version 1.0.0
 */
public class JedisCommandsListTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.8.128", 6379);
        String stringResult = "";
        Long longResult=-777L;
        List<String> listResult=new ArrayList<>();
        Set<String> setResult=new HashSet<>();
        Map<String,String> mapResult=new HashMap<>();

        /***************** List操作(start) *****************/
        //longResult=jedis.rpush("Lk","1","2","3");//把值加入列表的右头部(向右加入列表)

        //longResult=jedis.lpush("Lk","a","b","c");//把值加入列表的左头部(向左加入列表)

        //longResult=jedis.llen("ko");//获取指定列表的长度，列表不存在返回0

        //listResult=jedis.lrange("Lk",0,-1);//获取指定列表指定长度的值，0，-1表示获取全部

        //stringResult=jedis.ltrim("Lk",2,4);//让指定列表只保留指定区间内的元素，不在指定区间之内的元素都将被删除。

        //stringResult=jedis.lindex("Lk",1);//获取指定列表指定索引处的值，不存在则返回null

        //stringResult=jedis.lset("Lk",3,"des");//设置指定列表的指定索引的值，索引超出范围则报错

        //longResult=jedis.lrem("Lk",1,"1");//从左侧删除count个 和value相同的值

        //stringResult=jedis.lpop("Lk");//从左侧删除并返回值。列表为空或不存在返回null

        //stringResult=jedis.rpop("Lk");//从右侧删除并返回值。列表为空或不存在返回null


        /***************** List操作(end) *****************/
        jedis.close();//关闭redis连接

        System.out.println("stringResult="+stringResult);
        System.out.println("longResult="+longResult);
        System.out.println("listResult="+listResult);
        System.out.println("setResult="+setResult);
        System.out.println("mapResult="+mapResult);
    }
}


