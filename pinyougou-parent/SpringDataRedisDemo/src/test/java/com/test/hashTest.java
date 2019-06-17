package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class hashTest {

    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void hashSetValue(){
        redisTemplate.boundHashOps("bigKeay").put("a", "悟空");
        redisTemplate.boundHashOps("bigKeay").put("b", "八戒");
        redisTemplate.boundHashOps("bigKeay").put("c", "悟净");
    }

    @Test
    public void hashGetKeys(){
        Set keys = redisTemplate.boundHashOps("bigKeay").keys();
        System.out.println(keys);
        String a = (String) redisTemplate.boundHashOps("bigKeay").get("a");
        System.out.println(a);
    }

    @Test
    public void hashGetValues(){
        List values = redisTemplate.boundHashOps("bigKeay").values();
        System.out.println(values);
    }
    @Test
    public void testRemoveValueByKey(){
        redisTemplate.boundHashOps("bigKeay").delete("a");
    }

}
