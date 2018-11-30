package com.streamcompute.learn.rookie.controller;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.streamcompute.learn.rookie.util.RedisPool;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

@RestController
public class RedisScan {
    @RequestMapping(value = "/getredis", method = RequestMethod.GET)
    public String getKey(){


        RedisPool pool = new RedisPool("127.0.0.1",6379,2);
        Jedis redis = pool.getClient();
        return redis.get(("*").toString());
    }

}
