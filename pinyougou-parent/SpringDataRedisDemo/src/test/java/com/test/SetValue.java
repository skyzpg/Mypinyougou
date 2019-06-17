package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class SetValue {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void setValue(){
        redisTemplate.boundSetOps("name").add("孙悟空");
        redisTemplate.boundSetOps("name").add("唐僧");
        redisTemplate.boundSetOps("name").add("八戒");
    }
    @Test
    public void getValue(){
        Set members = redisTemplate.boundSetOps("name").members();
        System.out.println(members);
    }

    @Test
    public void deleValue(){
        redisTemplate.boundSetOps("name").remove("孙悟空");
    }
}
