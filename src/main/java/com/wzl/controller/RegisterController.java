package com.wzl.controller;

import com.wzl.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class RegisterController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping(value = "/register")
    public String getRegister(){
        return "register";
    }
    @PostMapping(value = "/register")
    public String Register (String name,String password,String img,String sign)throws SQLException {
        int n = userService.addUser(name, password,img,sign);
        //roleService.addRole(n);

        System.out.println("new user's id = "+n);
        return "register_successful";

    }

}
