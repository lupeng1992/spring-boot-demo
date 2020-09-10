package com.example.demo.controller;

import com.example.demo.context.SystemContext;
import com.example.demo.entity.ResultModel;
import com.example.demo.entity.User;
import com.example.demo.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Api(value = "测试类接口")
@RequestMapping("/demo")
@RestController
public class DemoController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private DemoService demoService;

    @ApiOperation("测试接口")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "name",dataType = "string",value = "姓名"),
            @ApiImplicitParam(name = "key",dataType = "string",value = "key")
    })
    @RequestMapping("/test")
    public String test(String name,String key){
        delCache(name, key);
        return "{"+name+":"+key+"}";
    }

    @ApiOperation("登录")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "name",dataTypeClass = String.class,required = true,value = "姓名"),
            @ApiImplicitParam(name = "age",dataTypeClass = int.class,required = true,value = "年龄")
    })
    @GetMapping("/login")
    public ResultModel<Object> login(String name, Integer age){
        SystemContext.setCurrentPerson(new User());
        User user = demoService.getUser(name);
        int nextInt =getNum();
        ResultModel<Object> stringResultModel = new ResultModel<Object>(200,"请求成功",""+nextInt);
        return stringResultModel;
    }


    public Integer getNum(){
        Object random = redisTemplate.opsForValue().get("random");
        if (random!=null){
            Integer ran = (Integer)random;
            return ran;
        }
        int nextInt = new Random().nextInt(100);
        redisTemplate.opsForValue().set("random",nextInt,1000*60, TimeUnit.SECONDS);
        return nextInt;
    }

    public void delCache(String name,String key){
        redisTemplate.delete("random");

    }

}
