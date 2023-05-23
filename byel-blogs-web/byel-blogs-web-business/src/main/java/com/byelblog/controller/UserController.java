package com.byelblog.controller;

import com.alibaba.fastjson.JSONObject;
import com.byelblog.common.result.Response;
import com.byelblog.common.result.ResponseResult;
import com.byelblog.entity.Users;
import com.byelblog.service.UsersService;
import com.byelblog.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UsersService usersService;

    @GetMapping("register")
    public Response<String> register(@RequestBody JSONObject object , HttpServletRequest httpServletRequest ){
        Users user = object.getObject("user",Users.class);
        if(user==null){
            return Response.fail("请输入账户密码");
        }

        if(!StringUtils.hasText(user.getUsername())){
            return Response.fail("用户名不可为空");
        }
        if(!StringUtils.hasText(user.getPassword())){
            return Response.fail("密码不可为空");
        }
        if(!StringUtils.hasText(user.getEmail())){
            return Response.fail("邮箱不可为空");
        }

        usersService.insert(user);
        return Response.ok("注册成功");
    }

    @GetMapping("login")
    public Response<String> login(@RequestBody JSONObject object , HttpServletRequest httpServletRequest ){
        System.out.println(object);
        Users user = object.getObject("user",Users.class);
        if(user==null){
            return Response.fail("请输入账户密码");
        }

        if(!StringUtils.hasText(user.getUsername())){
            return Response.fail("用户名不可为空");
        }
        if(!StringUtils.hasText(user.getPassword())){
            return Response.fail("密码不可为空");
        }

        int exist = usersService.qryLogin(user);

        if (exist!=1){
            return Response.fail("用户不存在或密码输入错误");
        }

        String  token = TokenUtil.generateToken(user);

        return Response.ok("登录成功",token);
    }
    //测试联通
    @GetMapping("check")
    public ResponseResult<Map<String,String>> check(){
        Map<String,String > map = new HashMap<>();
        map.put("name","zs");
        return new  ResponseResult<>("0","成功",map);
    }
}
