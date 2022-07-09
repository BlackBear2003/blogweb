package com.wzl.controller;


import com.wzl.entity.User;
import com.wzl.service.Impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

@RestController
public class LoginController {
    @Autowired
    UserServiceImpl userService;
    @GetMapping(value="/")
    public String getIndex(){
        return "index";
    }

    @GetMapping(value="/login")
    public String getLogin(){
        return "login.html";
    }

    @ResponseBody
    @PostMapping(value="/login")
    public String login(String name,String password) throws SQLException {
        //使用 shiro 登录验证
        //1 认证的核心组件：获取 Subject 对象
        Subject subject = SecurityUtils.getSubject();
        //2 将登陆表单封装成 token 对象
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        try {
            //3 让 shiro 框架进行登录验证：
            subject.login(token);
        } catch (Exception e) {
            e.printStackTrace();
            return "login_error";
        }
        User user = userService.getUsersByName(name).get(0);

        return "success";
    }
}
