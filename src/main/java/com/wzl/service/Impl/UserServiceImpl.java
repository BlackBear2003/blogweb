package com.wzl.service.Impl;

import com.wzl.entity.User;
import com.wzl.mapper.UserMapper;
import com.wzl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserById(int id) throws SQLException {
        return userMapper.getUserById(id);
    }

    @Override
    public List<User> getUsersByName(String name) throws SQLException {
        return userMapper.getUsersByName(name);
    }

    @Override
    public int addUser(String name, String password, String img, String sign) throws SQLException {
        User user = new User(0,name,password,img,sign);
        int val = userMapper.addUser(user);
        return user.getId();
    }

    @Override
    public int deleteUser(int id) throws SQLException {
        return userMapper.deleteUser(id);
    }

    @Override
    public int getUserRoleById(int id) throws SQLException {
        return userMapper.getUserRoleById(id);
    }

    @Override
    public int updateUser(User user) throws SQLException {
        return userMapper.updateUser(user);
    }
}
