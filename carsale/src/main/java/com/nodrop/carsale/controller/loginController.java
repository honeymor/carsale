package com.nodrop.carsale.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nodrop.carsale.Entity.User;
import com.nodrop.carsale.Entity.Car;

import com.nodrop.carsale.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2024-09-17
 */
@RestController
@RequestMapping("/login")
public class loginController {
    @Autowired
    private IUserService userService;

    @PostMapping("")
    public boolean login(@RequestBody User user) {
        String username = user.getName();
        String password = user.getPassword();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", username);
        queryWrapper.eq("password", password);
        return userService.exists(queryWrapper);
    }
}