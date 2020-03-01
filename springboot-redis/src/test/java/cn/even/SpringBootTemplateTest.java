package cn.even;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class SpringBootTemplateTest {
    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void testGet() {
        Object v = redisTemplate.opsForValue().get("k1");
        System.out.println(v);
        Assert.assertNotNull(v);
    }
}
