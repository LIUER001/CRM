package com.bjpowernode;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * 你相信光吗
 * 2021/9/11
 */
public class App3 {
    public static void main(String[] args) {
        JedisPool pool = null;

        try {
            pool = RedisUtils.open("192.168.199.129", 6379);
            Jedis jedis = pool.getResource();
            jedis.flushAll();
            Transaction transaction = jedis.multi();
            transaction.set("a", "1");
            transaction.set("b", "2");
            transaction.set("c", "3");
            List<Object> list = transaction.exec();
            for (Object o : list) {
                System.out.println(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            RedisUtils.close();
        }
    }
}
