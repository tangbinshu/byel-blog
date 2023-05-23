package com.byelblog.controller;

import com.byelblog.common.result.ResponseResult;
import com.byelblog.entity.PageSet;
import com.byelblog.entity.Users;
import com.byelblog.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private UsersService usersService;

    @GetMapping("qryUsers")
    public ResponseResult<List<Users>> qryUsers(){
        Users us = new Users();
        us.setUsername("zs");
        List<Users> list = usersService.qryByPage(us,new PageSet(1,5));
        return  new ResponseResult<>("0","成功",list);
    }
}
