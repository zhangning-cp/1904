package com.xcy.controller;


import com.xcy.pojo.User;
import com.xcy.service.UserService;

import com.xcy.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RedisController {

    @Autowired
    UserService userService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

   /* @Autowired
    JedisClient jedisClient;*/

    @RequestMapping("getUserRedis")
    @ResponseBody
    public List<User> getUserList(){
/*
       String str =  jedisClient.get("listUser");
        System.out.println("利用自己编写的工具类获取到的值："+str);*/
        //如何从redis中获取值
      String jsonStr =   redisTemplate.boundValueOps("listUser").get();
        List<User> allUser = null;
      if(jsonStr == null || jsonStr.equals("")){
          allUser = userService.getAllUser();
          //转换为json,放入到redis
          String json= JsonUtils.objectToJson(allUser);
          redisTemplate.boundValueOps("listUser").set(json);
      }else{
          allUser = JsonUtils.jsonToList(jsonStr,User.class);
      }

      return allUser;
    }

}
