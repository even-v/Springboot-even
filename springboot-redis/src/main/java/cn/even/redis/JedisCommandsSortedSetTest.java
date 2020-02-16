package cn.even.redis;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.Tuple;
import redis.clients.jedis.params.sortedset.ZAddParams;

import java.util.*;

/**
 * <p>
 * 描述:JedisCommands接口中关于Set的操作方法练习。
 * <p>
 * Redis 有序集合和集合一样也是string类型元素的集合,且不允许重复的成员。
 * <p>
 * 不同的是每个元素都会关联一个double类型的分数。redis正是通过分数来为集合中的成员进行从小到大的排序。
 * <p>
 * 有序集合的成员是唯一的,但分数(score)却可以重复。
 * <p>
 * 集合是通过哈希表实现的，所以添加，删除，查找的复杂度都是O(1)。 集合中最大的成员数为 232 - 1 (4294967295, 每个集合可存储40多亿个成员)。
 * </p>
 *
 * @author ipark123@163.com
 * @version 1.0.0
 * @date 2020-02-16
 */
public class JedisCommandsSortedSetTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.8.128", 6379);
        String stringResult = "";
        Long longResult = -777L;
        Double doubleResult = -777.777;
        List<String> listResult = new ArrayList<>();
        Set<String> setResult = new HashSet<>();


        /***************** SortedSet操作(start) *****************/

        ////Long zadd(String key, double score, String member);
        //longResult=jedis.zadd("zk",2.5,"asd");//SortedSet增加带有指定分数的成员，若成员已存在则修改其分数

        ////Long zadd(String key, double score, String member, ZAddParams params);
        //ZAddParams params=ZAddParams.zAddParams();//SortedSet增加key的参数
        ////params.nx();//不存在
        //params.xx();//已存在
        //longResult=jedis.zadd("zk",3.7,"zv1",params);

        ////Long zadd(String key, Map<String, Double> scoreMembers);
        //Map<String,Double> map=new HashMap<>();
        //map.put("zv2",4.5);
        //map.put("zv3",6.5);
        //map.put("zv4",2.0);
        //longResult=jedis.zadd("zk",map);//把map中的成员加入SortedSet中

        ////Long zadd(String key, Map<String, Double> scoreMembers, ZAddParams params);
        //ZAddParams params=ZAddParams.zAddParams();//SortedSet增加key的参数
        ////params.nx();//不存在
        //params.xx();//已存在
        //Map<String,Double> map=new HashMap<>();
        //map.put("zv2",4.5);
        //map.put("zv3",6.5);
        //map.put("zv4",2.0);
        //longResult=jedis.zadd("zk",map,params);//把map中的成员加入SortedSet中

        ////Set<String> zrange(String key, long start, long end);
        //setResult=jedis.zrange("zk",0,-1);//获取SortedSet中范围从start至end的成员

        ////Long zrem(String key, String... member);
        // longResult=jedis.zrem("zk","asd");//移除指定SortedSet中的指定成员

        //// Double zincrby(String key, double score, String member);
        //// Double zincrby(String key, double score, String member, ZIncrByParams params);
        //doubleResult=jedis.zincrby("zk", 2, "zv5");//指定SortedSet指定成员的分数增加score，若不存在则新增

        ////Long zrank(String key, String member);
        //longResult= jedis.zrank("zk","zv5");//正序获取指定SortedSet指定成员的Rank排名(排名从0开始)

        ////Long zrevrank(String key, String member);
        //longResult=jedis.zrevrank("zk","zv5");//反序获取指定SortedSet指定成员的Rank排名(排名从0开始)

        ////Set<String> zrevrange(String key, long start, long end);
        //setResult = jedis.zrevrange("zk", 0, -1);//反序获取指定SortedSet中指定范围的成员

        ////Set<Tuple> zrangeWithScores(String key, long start, long end);
        //// Set<Tuple> zrevrangeWithScores(String key, long start, long end);//反序获取指定SortedSet指定范围的成员(带分数)
        //Set<Tuple> tuple=jedis.zrangeWithScores("zk",0,-1);//正序获取指定SortedSet指定范围的成员(带分数)
        //tuple.forEach(tup -> {
        //   System.out.print(new String(tup.getElement()));
        //   System.out.println("="+tup.getScore());
        //});

        //Long zcard(String key);
        //longResult=jedis.zcard("zk");//获取指定SortedSet的成员数量

        ////Double zscore(String key, String member);
        //doubleResult=jedis.zscore("zk","zv3");//获取指定SortedSet指定成员的分数，不存在返回null

        //// List<String> sort(String key, SortingParams sortingParameters);
        //SortingParams params = new SortingParams();
        //params.alpha();
        ////params.asc();//升序
        ////params.desc();//降序
        ////params.nosort();//不排序
        //listResult = jedis.sort("zk", params);//对SortedSet进行排序，对成员排序(会将成员转换为double，若成员不为double则报错)，不是对成员分数排序

        ////Long zcount(String key, double min, double max);
        //longResult=jedis.zcount("zk",2,6);//返回SortedSet分数在min至max之间的成员个数(闭区间)

        ////Set<String> zrangeByScore(String key, double min, double max);
        ////Set<String> zrevrangeByScore(String key, double max, double min);//反序返回SortedSet分数在min至max之间的成员
        //setResult=jedis.zrangeByScore("zk",2,5);//正序返回SortedSet分数在min至max之间的成员

        //TODO 待完善 各种条件下的排序
        ////Set<String> zrangeByScore(String key, double min, double max, int offset, int count);
        ////Set<String> zrangeByScore(String key, String min, String max, int offset, int count);
        ////Set<Tuple> zrangeByScoreWithScores(String key, double min, double max);
        ////Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min);
        ////Set<Tuple> zrangeByScoreWithScores(String key, double min, double max, int offset, int count);
        ////Set<String> zrevrangeByScore(String key, String max, String min, int offset, int count);
        ////Set<Tuple> zrangeByScoreWithScores(String key, String min, String max);
        ////Set<Tuple> zrevrangeByScoreWithScores(String key, String max, String min);
        ////Set<Tuple> zrangeByScoreWithScores(String key, String min, String max, int offset, int count);
        ////Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min, int offset, int count);
        ////Set<Tuple> zrevrangeByScoreWithScores(String key, String max, String min, int offset, int count);

        ////Long zremrangeByRank(String key, long start, long end);
        //longResult=jedis.zremrangeByRank("zk",0,2);//移除执行SortedSet rank排名在start至end的成员(闭区间)

        ////Long zremrangeByScore(String key, double start, double end);
        longResult=jedis.zremrangeByScore("zk",0,2);//移除执行SortedSet 分数在start至end的成员(闭区间)


        /***************** SortedSet操作(end) *****************/
        jedis.close();//关闭redis连接

        System.out.println("stringResult=" + stringResult);
        System.out.println("longResult=" + longResult);
        System.out.println("listResult=" + listResult);
        System.out.println("setResult=" + setResult);
        System.out.println("doubleResult=" + doubleResult);

    }
}


