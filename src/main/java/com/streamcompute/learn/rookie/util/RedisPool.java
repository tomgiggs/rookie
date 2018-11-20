package com.streamcompute.learn.rookie.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.Serializable;

public class RedisPool implements Serializable {
    JedisPoolConfig redisConfig = new JedisPoolConfig();

    String host = "127.0.0.1";
    int port = 6379;
    int poolSize = 20;
    JedisPool pool = null;

    public RedisPool(String host, int port, int size){
        this.host=host;
        this.poolSize = size;
        this.port = port;
    }

    private void makePool(){
        redisConfig.setMaxTotal(poolSize);
        redisConfig.setMaxWaitMillis(3000);
        pool = new JedisPool(redisConfig,host,port);
    }
    public Jedis getClient(){
        if(pool==null){
            makePool();
        }
        return pool.getResource();
    }

}
