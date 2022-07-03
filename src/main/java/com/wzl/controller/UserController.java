package com.wzl.controller;

import com.wzl.entity.Post;
import com.wzl.entity.User;
import com.wzl.service.Impl.InteractionServiceImpl;
import com.wzl.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserServiceImpl userService;
    @Autowired
    InteractionServiceImpl interactionService;

    @GetMapping(value = "/info")
    public User getInfo(int id) throws SQLException {
        User user=userService.getUserById(id);
        user.setPassword("********");
        return user;
    }

    @PostMapping(value = "/changeSign")
    public String changeSign(int id,String sign) throws SQLException {
        User user = userService.getUserById(id);
        user.setSign(sign);
        userService.updateUser(user);
        return "success";
    }

    @PostMapping(value = "/changeImg")
    public String changeImg(int id,String img) throws SQLException {
        User user = userService.getUserById(id);
        user.setImg(img);
        userService.updateUser(user);
        return "success";
    }

    @GetMapping(value = "/delete")
    public String deleteUser(int id) throws SQLException {

        userService.deleteUser(id);
        return "success";
    }


    @GetMapping(value = "/thumb")
    public List<Post> getPostsByUserThumbed(int id){
        return interactionService.getPostsByUserThumb(id);
    }

    @GetMapping(value = "/getUserByName")
    public User getUserByNameDirectly(String name) throws SQLException {
        User user = userService.getUsersByName(name).get(0);
        return user;
    }
}
