package com.streamcompute.learn.rookie.util;

import redis.clients.jedis.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(20);
        config.setMaxWaitMillis(3000);
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();
        HostAndPort hostAndPort1 = new HostAndPort("127.0.0.1", 6379);
        HostAndPort hostAndPort2 = new HostAndPort("127.0.0.1", 6380);
        HostAndPort hostAndPort3 = new HostAndPort("127.0.0.1", 6381);

        nodes.add(hostAndPort1);
        nodes.add(hostAndPort2);
        nodes.add(hostAndPort3);
        JedisCluster cluster = new JedisCluster(nodes,config);
        cluster.getClusterNodes();


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
