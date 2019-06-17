package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class ListValue {

    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void setValue(){
        redisTemplate.boundListOps("name1").leftPush("悟空");
        redisTemplate.boundListOps("name1").leftPush("八戒");
        redisTemplate.boundListOps("name1").leftPush("唐僧");
    }

    @Test
    public void getValue(){
        List list = redisTemplate.boundListOps("name1").range(0, 3);
        System.out.println(list);
        String value = (String) redisTemplate.boundListOps("name1").index(3);
    }
}
