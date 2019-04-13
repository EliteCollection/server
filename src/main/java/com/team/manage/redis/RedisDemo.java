package com.team.manage.redis;

import redis.clients.jedis.Jedis;

import java.util.List;

import static redis.clients.jedis.Protocol.Command.LRANGE;

/**
 * Create By tcyu
 * Create time 2019/4/13 11:44 PM
 * Description Redis简单练习
 */
public class RedisDemo {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost") ;
        System.out.println("连接本地的 Redis 服务成功！");
        // 查看服务是否运行
         System.out.println("服务 正在运行: " + jedis.ping());
         jedis.set("zhang","张三");
         String a = jedis.get("zhang");
//        System.out.println(a);

        //存入一个list
        jedis.lpush("list",new String[]{"张三","李四","万物"});
        List<String> list = jedis.lrange("list", 0, 2);
//        String list1 = jedis.lpop("list");
//        System.out.println(list1);


        for (String s : list) {
            System.out.println(s);
        }
    }
}
