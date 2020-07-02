package com.donne.redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.ReadMode;
import org.redisson.config.SentinelServersConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import javax.crypto.KeyGenerator;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Author: yinyansheng
 * @Date: 2020-07-01
 */
public class RedisConfig {
    public static void main(String[] args) {

        String masterName = "mymaster";
        Set<String> sentinelSet = new HashSet<String>();
        sentinelSet.add("119.3.134.1:26379");
        sentinelSet.add("119.3.134.1:26380");
        sentinelSet.add("119.3.134.1:26381");

        JedisPoolConfig config = new JedisPoolConfig();

        JedisSentinelPool sentinelPool = new JedisSentinelPool(masterName, sentinelSet, config);
        Jedis jedis = null;
        try {
            jedis = sentinelPool.getResource();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }



        String name = jedis.get("name");
        System.out.println(name);
        jedis.set("name1", "aaaaaaaaa");
        System.out.println(jedis.get("name1"));
    }
}
