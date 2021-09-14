//crud
package com.bjpowernode;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.199.129", 6379);
        jedis.flushAll();
       /* jedis.set("name", "tom");
        String name = jedis.get("name");
        System.out.println(name);*/

        jedis.hset("hset1", "str1", "abc");
        String str1 = jedis.hget("hset1", "str1");
        System.out.println(str1);
        System.out.println("=======================");

        Map<String,String> map = new HashMap<>();
        map.put("id", "001");
        map.put("name", "zhangsan");
        map.put("age", "12");
        jedis.hmset("student", map);
        List<String> list = jedis.hmget("student", "id","name","age");
        for (String str : list) {
            System.out.println(str);
        }
    }
}
