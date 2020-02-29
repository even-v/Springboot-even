# Redis

## 简介

REmote DIctionary Server(Redis) 是一个由Salvatore Sanfilippo写的key-value存储系统。Redis是一个开源的使用ANSI C语言编写、遵守BSD协议、支持网络、可基于内存亦可持久化的日志型、Key-Value数据库，并提供多种语言的API。它通常被称为数据结构服务器，因为值（value）可以是 字符串(String), 哈希(Hash), 列表(list), 集合(sets) 和 有序集合(sorted sets)等类型。

Redis 是完全开源免费的，遵守BSD协议，是一个高性能的key-value数据库。

Redis 与其他 key - value 缓存产品有以下三个特点：

- Redis支持数据的持久化，可以将内存中的数据保存在磁盘中，重启的时候可以再次加载进行使用。
- Redis不仅仅支持简单的key-value类型的数据，同时还提供list，set，zset，hash等数据结构的存储。
- Redis支持数据的备份，即master-slave模式的数据备份。

### Redis 优势

- 性能极高 – Redis能读的速度是110000次/s,写的速度是81000次/s 。
- 丰富的数据类型 – Redis支持二进制案例的 Strings, Lists, Hashes, Sets 及 Ordered Sets 数据类型操作。
- 原子 – Redis的所有操作都是原子性的，意思就是要么成功执行要么失败完全不执行。单个操作是原子性的。多个操作也支持事务，即原子性，通过MULTI和EXEC指令包起来。
- 丰富的特性 – Redis还支持 publish/subscribe, 通知, key 过期等等特性。

### Redis与其他key-value存储有什么不同？

- Redis有着更为复杂的数据结构并且提供对他们的原子性操作，这是一个不同于其他数据库的进化路径。Redis的数据类型都是基于基本数据结构的同时对程序员透明，无需进行额外的抽象。
- Redis运行在内存中但是可以持久化到磁盘，所以在对不同数据集进行高速读写时需要权衡内存，因为数据量不能大于硬件内存。在内存数据库方面的另一个优点是，相比在磁盘上相同的复杂的数据结构，在内存中操作起来非常简单，这样Redis可以做很多内部复杂性很强的事情。同时，在磁盘格式方面他们是紧凑的以追加的方式产生的，因为他们并不需要进行随机访问。

## Redis安装

官网地址：[https://redis.io/](https://redis.io/)

### window下安装

安装包地址：[https://github.com/microsoftarchive/redis/releases](https://github.com/microsoftarchive/redis/releases)

安装好后目录结构如下图

![image-20200229164130249](https://github.com/even-v/Springboot-even/blob/master/springboot-redis/src/main/resources/public/image-20200229164130249.png)

把该目录配置到环境变量path中，然后启动cmd执行 `redis-server.exe redis.windows.conf` 会出现如下的界面，表示启动成功。

![image-20200229164430519](https://github.com/even-v/Springboot-even/blob/master/springboot-redis/src/main/resources/public/image-20200229164430519.png)

不要关闭当前窗口，重新打开一个新的cmd执行 `redis-cli.exe`，表示启动redis客户端，出现如下图表示可以执行redis语句了。

![image-20200229164705580](https://github.com/even-v/Springboot-even/blob/master/images/image-20200229164705580.png)

测试redis性能 ，可以通过执行命令 `redis-benchmark`来测试性能

### ubuntu下安装

## key(键)相关的语句

`shutdown`

​	关闭数据库

`exit`

​	退出

`select index`

​	切换库

`dbsize`

​	查看当前库key的数量

`flushdb`

​	清空当前库

`flushall`

​	清空所有库
​	
`keys *`

​	所有key

`exists key`
	判断key是否存在

`move key db`
	移动key值db库

`expire key second(秒)`
	为key设置过期时间，秒为单位

`ttl key`
	查看key还有多少秒过期，-1表示永不过期，-2表示已过期

`type key`
	查看key的类型

## String(字符串)

`set key value [NX|XX]`
	设置key的值为value，NX和XX为参数，其中NX表示key不存在的情况下才进行操作，XX表示key存在的情况下才进行操作

`setNX key value`
	等效于`set key value NX。NX(Not eXists不存在)`，成功返回1，失败返回0

`get key`
	获得key的值

`MSET key value[key value ...]`
	一次为一个或多个字符串键设置值

`MSETNX key value[key value...]`
	只有给定键都不存在的情况下才会设置成功

`MGET key[key...]`
	一次返回一个或多个键的值

`GETSET key new-value`
	将键的值设置为new-value，并返回旧值

`APPEND key value`
	将value值添加至ket已存储内容的末尾，并返回新字符串的长度

`STRLEN key`
	返回key的长度

`setex(set with expire) key second  value / setnx(set if not exist)`
	设置key过期时间

### 字符串索引

​	正数索引：开头向末尾从0开头，到长度减1结束
​	负数索引：末尾向开头从-1开始，到-长度结束

`SETRANGE key index value`
	范围设置值：从索引index开始，用value覆盖给定key所存储的字符串值，只接受正数索引。

`GETRANGE key start end`
	范围取值：返回key位于strat至end之间的内容(闭区间)，支持正数索引和负数索引

### 字符串整数

`INCRBY key number`
	将key的值增加number，若key不存在则初始化为0

`DECRBY key number`
	将key的值减少number，若key不存在则初始化为0

`INCY key`
	自增1，等效于 INCRBY key 1
	
`DECY key`
	自减1，等效于DECYBY key 1

### 字符串浮点数

INCRBYFLOAT key increment
	为字符串键key储存的值加上increment，返回键key的值，想要达到减的效果则increment传递负数即可
	

## 	Hash(散列)

一个散列由多个域值对（field-value pair）组成，散列的域和值都可以是文字、整数、浮点数或者二 进制数据。同一个散列里面的每个域必 须是独一无二、各不相同的，而域的值则没有这一要求，换句话说，不同域的值可以是重复的。

`HSET key field value`
	关联域值对:在散列键key中关联给定的域值对field和value如果域field之前没有关联值,那么命令返回1;如果域field已经有关联值，那么命令用新值覆盖旧值，并返回0。
	
`HSETNX key field value`
	仅当域不存在时关联值：如果散列键key中，域field不存在（也即是，还没有与之相关联的值），那么关联给定的域值对field和value。

`HGET key field`
	获取域关联的值：返回散列键key中，域field所关联的值。如果域field没有关联值，那么返回nil。

`HGETALL key`
	获取key中所有域field关联的值

`HEXISTS key field`
	检查域是否存在：查看散列键key中，给定域field是否存在：存在返回1，不存在返回0。

`HDEL key field [field ...]`
	删除给定的域值对：删除散列键key中的一个或多个指定域，以及那些域的值。不存在的域将被忽略。命令返回被成功 删除的域值对数量。

`HLEN key`	
	获取散列包含的键值对数量：返回散列键key包含的域值对数量。

### 批量操作

`HMSET key field value [field value ...]`
	在散列键key中关联多个域值对，相当于同时执行多个HSET。

`HMGET key field [field ...]`
	返回散列键key中，一个或多个域的值，相当于同时执行多个HGET。
	
`HKEYS key` 
	返回散列键key包含的所有域。 

`HVALS key`
	返回散列键key中，所有域的值。 

`HGETALL key` 
	返回散列键key包含的所有域值对。

### 数字操作

`HINCRBY key field increment` 
	为散列键key中，域field的值加上整数增量increment。

`HINCRBYFLOAT key field increment` 
	为散列键key中，域field的值加上浮点数增量increment。

## List(列表)

一个列表可以包含一个或以上数量的 项（item），每个项按照它们被推入到列表的位置来排列。
每个列表项所处的位置决定了这个项的索引值（index），索引以0为开始，从列表的左端到右端依次递增，
位于列表最左端（表头）的项的索引为 0 ，而位于列表最右端（表尾）的 项的索引为 N-1 ，其中 N 为列表的长度。
列表包含的项可以出现重复，它们不必是唯一的。

### 列表的推入和弹出

`LPUSH key value[value...]`
	从列表的左端推入:将一个或以上数量的值依次推入到列表的左端，命令返回新值被推入之后，列表目前包含的项数量。

`RPUSH key value [value ...]`
	从列表的右端推入:将一个或以上数量的值依次推入到列表的右端，命令返回新值被推入之后，列表目前包含的项数量。

`LPOP key`
	移除并返回列表最左端的项。 
	
`RPOP key`
	移除并返回列表最右端的项。

`LLEN key`
	获取列表的长度：返回列表键key的长度，也即是，返回列表包含的列表 项数量。

`LINDEX key index`
	返回给定索引上的项：返回列表键key中，指定索引index上的列表项。index 索引可以是正数或者负数。

`LRANGE key start stop`
	返回给定索引范围之内的所有项：返回列表键key中，从索引start至索引stop范围内的所有列表项。两个索引参数都可以是正数或者负数。

### 插入和删除操作

`LSET key index value`
	设置指定索引上的列表：将列表键key索引index上的列表项设置为value，设置成功时命令返回OK。如果index参数超过了列表的索引范围，那么命令返回一个错误。

`LINSERT key BEFORE|AFTER pivot value`
	在指定位置插入列表项：根据命令调用时传递的是BEFORE选项还是AFTER选项，将值value插入到指定列表项pivot的之前或者之后。当pivot不存在于列表key时，不执行任何操作。

`LREM key count value`
	从列表中删除指定值：根据参数count的值，移除列表中与参数value相等的列表项：
		如果 count > 0 ，那么从表头开始向表尾搜索，移除最多 count 个值为 value 的列表项。
		如果 count < 0 ，那么从表尾开始向表头搜索，移除最多 abs(count) 个值为 value 的列表项。
		如果 count = 0 ，那么移除列表中所有值为 value 的列表项。

`LTRIM key start stop`
	修剪列表：对一个列表进行修剪(trim)，让列表只保留指定索引范围内的列表项，而将不在范围内的其他列表项全部删除。两个索引都可以是正数或者负数。

### 阻塞弹出

`BLPOP key [key ...] timeout`
	LPOP命令的阻塞版本；命令会以从左到右的顺序，访问给定的各个列表，并弹出首个非空列表最左端的项；
	如果所有给定列表都为空，那么客户端将被阻塞，直到等待超时，或者有可弹出的项出现为止；
	设置timeout参数为0表示永远阻塞。

`BRPOP key [key ...] timeout`
	RPOP命令的阻塞版本：命令会以从左到右的顺序，访问给定的各个列表，并弹出首个非空列表最右端的项；
	如果所有给定列表都为空，那么客户端将被阻塞，直到等待超时，或者有可弹出的项出现为止；
	设置timeout参数为0表示永远阻塞。
	
`RPOPLPUSH key1 key2`
	把key1(原列表)右边的移除并 移至key2(目标列表)的左边

## Set(集合)

集合（set）：Redis 的集合以无序的方式储存多个各不相同的元素。
用户可以快速地向集合添加元素，或者从集合里面删除元素，也可以对多个集合进行集合运算操作，比如计算并集、交集和差集。

`SMEMBERS key`
	查看集合中所有元素

`SRANDMEMBER key count`
	从key中随机出count个值	

`SADD key element [element ...]`
	添加元素：将一个或多个元素添加到给定的集合里面，已经存在于集合的元素会自动被忽略，命令返回新添加到集合的元素数量。

`SREM key element [element ...]`
	移除元素：移除集合中的一个或者多个元素，不存在于集合中的元素会自 动被忽略，命令返回存在并且被移除的元素数量。

`SISMEMBER key element`
	检查给定的元素是否存在于集合：存在的话返回1；如果元素不存在，或者给定的键不存在，那么返回0。

`SCARD key`
	返回集合包含的元素数量（也即是集合的基数）。

`SMEMBERS key`
	返回集合包含的所有元素

`SPOP key`
	随机地从集合中移除并返回一个元素。

`SRANDMEMBER key [count]`
	如果没有给定可选的 count 参数，那么命令随机地返回集合中的一个元素。如果给定了 count 参数，那么：
		当 count 为正数，并且少于集合基数时，命令返回一个包含 count 个元素的数组，数组中的每个元素各不相同。如果 count 大于或等于集合基数，那么命令返回整个集合。
		当 count 为负数时，命令返回一个数组，数组中的元素可能会重复出现多次，而数组的长度为count 的绝对值。
		和 SPOP 不同， SRANDMEMBER 不会移除被返回的元素。

### 集合运算

`SDIFF key [key ...]` 
	差集运算：计算所有给定集合的差集，并返回结果。	

`SDIFFSTORE destkey key [key ...]` 
	差集运算：计算所有给定集合的差集，并将结果储存到destkey。

`SINTER key [key ...]` 
	交集运算：计算所有给定集合的交集，并返回结果。

`SINTERSTORE destkey key [key ...]`
	交集运算：计算所有给定集合的交集，并将结果储存到destkey。

`SUNION key [key ...]` 	
	并集运算：计算所有给定集合的并集，并返回结果。

`SUNIONSTORE destkey key [key ...]` 
	并集运算：计算所有给定集合的并集，并将结果储存到destkey。

## Sorted Set(有序集合)

有序集合和集合一样，都可以包含任意数量的、各不相同的元素（ element），不同于集合的是，有序集合的每个元素都关联着一个浮点数格式的分值（score），
并且有序集合会按照分值，以从小到大的顺序来排列有序集合中的各个元素。
虽然有序集合中的每个元素都必 须是各不相同的，但元素的分 值并没有这一限制，换句话来说，两个不同元素的分值可以是相同的。

`ZADD key score element [[score element] [score element] ...]`
	添加元素：按照给定的分值和元素，将任意数量的元素添加到有序集合里面，命令的返回 值为成功添加的元素数量。

`ZREM key element [element ...]`
	删除元素：从有序集合中删除指定的元素，以及这些元素关联的分值，命令返回被成功删除的元素数量。

`ZSCORE key element`
	返回有序集合中，指定元素的分值。

`ZINCRBY key increment element`
	为有序集合指定元素的分值加上增量increment，命令返回执行操作之后，元素的分值(increment为负数表示减少分值)。

`ZCARD key`
	返回有序集合包含的元素数量（基数）。

`ZRANK key element`
	返回元素的排名（rank）：返回指定元素在有序集合中的排名，其中排名按照元素的分值从小到大计算。

`ZREVRANK key member`
	返回元素的逆序排名（reverse rank）：返回成员在有序集合中的逆序排名，其中 排名按照元素的分值从大到小计算。

`ZRANGE key start stop [WITHSCORES]`
	获取指定索引范围内的升序元素：返回有序集合在按照分值从小到大排列元素（升序排列） 的情况下，
	索引start至索引stop范围之内的所有元素。两个索引都可以是正数或者负数。当给定WITHSCORES选项时，命令会将元素和分值一并返回。

`ZREVRANGE key start stop [WITHSCORES]`
	获取指定索引范围内的降序元素：返回有序集合在按照分值从大到小排列元素（降序排列） 的情况下，
	索引start至索引stop范围之内的所有元素。两个索引都可以是正数或者负数。当给定 WITHSCORES 选项时，命令会把元素和分值一并返回。

`ZRANGEBYSCORE key min max [WITHSCORES] [LIMIT offset count]`
	获取指定分值范围内的升序元素：返回有序集合在按照分值升序排列元素的情况下，分值在 min 和 max 范围之内的所有元素。

`ZREVRANGEBYSCORE key min max [WITHSCORES] [LIMIT offset count]`
	获取指定分值范围内的降序元素：返回有序集合在按照分值降序排列元素的情况下，分值在 min 和 max 范围之内的所有元素。

`ZCOUNT key min max`
	计算给定分值范围内的元素数量

`ZREMRANGEBYRANK key start stop`
	移除指定排名范围内的升序排列元素

`ZREMRANGEBYSCORE key min max`
	移除指定分值范围内的升序排列元素：移除有序集合中，分值范围介于 min 和 max 之内的所有元素。

### 集合运算操作

`ZUNIONSTORE destkey numkeys key [key ...]`  
	计算并集：计算结果会被储存到 destkey 里面，命令返回结果集的基数。

`ZINTERSTORE destkey numkeys key [key ...]` 
	计算交集：计算结果会被储存到 destkey 里面，命令返回结果集的基数。

## HyperLogLog(基数统计)

Redis HyperLogLog是用来做基数统计的算法，HyperLogLog的优点是，在输入元素的数量或者体积非常非常大时，计算基数所需的空间总是固定的、并且是很小的。
但是，因为HyperLogLog只会根据输入元素来计算基数，而不会储存输入元素本身，所以HyperLogLog不能像集合那样，返回输入的各个元素。
什么是基数？比如数据集{1,3,5,7,5,7,8}，那么这个数据集的基数集为{1,3,5,7,8},基数(不重复元素)为5。基数估计就是在误差可接受的范围内，快速计算基数。

`PFADD key element [element ...]`
	将任意数量的元素添加到指定的HyperLogLog里面。这个命令可能会对HyperLogLog进行修改，以便反映新的基数估算值，如果HyperLogLog的基数估算值在命令执行之后出现了变化，那么命令返回1，否则返回0。

`PFCOUNT key [key ...]`
	当只给定一个HyperLogLog时，命令返回给定 HyperLogLog 的基数估算值。当给定多个HyperLogLog时，命令会先对给定的HyperLogLog进行并集计算，得出一个合并后的HyperLogLog，然后返回这个合并HyperLogLog的基数估算值作为命令的结果（合并得出的HyperLogLog不会被储存，使用之后就会被删掉）。

`PFMERGE destkey sourcekey [sourcekey ...]`
	将多个HyperLogLog合并为一个HyperLogLog，合并后的HyperLogLog的基数估算值是通过对所有给定HyperLogLog进行并集计算得出的。

## Transaction(事务)

`discard`
	取消事务
	
`exec`
	执行所有事物块

`multi`
	标记一个事务块的开始

`watch`
	监视一个(或多个)key，如果在事务执行之前这些key别其它命令改动，那么事务将被打断。
	
`unwatch`
	取消watch命令对所有key的监视

## master/slave(主从复制)

master:写为主
slave：读为主

配从(库)不配主(库)
	slaveof 主库ip 主库port(每次与master断开后，都需要重新连接，除非写入配置文件中)
	
`info replication`
	查看redis信息

一主二仆：一个master两个slave
	主库挂掉后，从库不动(不会自动升级为主库)；
	主库挂掉又恢复后，从库自动重新连接；
	从库挂掉又恢复后后，从库变为主库(除非写入配置文件中)；

薪火相传：一个库既可以为master，同时也可以为slave

反客为主：
	`slaveof no one`
		从库变为主库


哨兵模式(sentinel)：可以理解为反客为主的自动版
新建sentinel.conf文件(文件名不可为错)