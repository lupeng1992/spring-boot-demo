package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author astupidcoder
 * @since 2020-09-09
 */
@Api
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @ApiOperation(value = "新增用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "姓名",required = true),
            @ApiImplicitParam(name = "age",value ="年龄",required = true),
    })
    @PostMapping(value = "/save")
    public User save(String name, Integer age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        boolean save = userService.save(user);
        return user;
    }

}
