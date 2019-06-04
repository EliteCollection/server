package com.team.manage.redis;

import com.alibaba.fastjson.JSONObject;
import com.team.manage.entity.User;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
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
         List<User> userList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setAccount("aaa" + i);
            user.setUserName("zzz" + i);
            userList.add(user);

        }

//        System.out.println(a);
        //清空list中的值
        jedis.ltrim("list",1,0);
        //存入一个list
        jedis.set("userList", JSONObject.toJSONString(userList));
        String s1 = jedis.get("userList");
        List<User> users = JSONObject.parseArray(s1,User.class);
        System.out.println(s1);
        List<String> list = jedis.lrange("list", 0, -1);
//        String list1 = jedis.lpop("list");
//        System.out.println(list1);


//        for (String s : list) {
//            System.out.println(s);
//        }
    }
}
