package com.bjpowernode;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 你相信光吗
 * 2021/9/10
 */
public class App1 {
    public static void main(String[] args) {
        JedisPool pool = null;
        try {
            pool = RedisUtils.open("192.168.199.129", 6379);
            Jedis jedis = pool.getResource();
            jedis.set("age", "11");
            String age = jedis.get("age");
            System.out.println(age);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            RedisUtils.close();
        }
    }
}
