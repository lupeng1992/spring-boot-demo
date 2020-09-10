package com.example.demo.service;

import com.example.demo.Action;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService{

    @Override
    @Action(name = "拦截获取用户信息操作")
    public User getUser(String name) {
        User user = new User();
        System.out.println("获取用户信息");
        name="22";
        return user;
    }
}
