package com.wzl.service;

import com.wzl.entity.User;
import com.wzl.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


public interface UserService {
    /**
     * 通过id查询用户
     *
     * @param id
     * @return
     * @throws SQLException
     */
    User getUserById(int id) throws SQLException;

    /**
     *通过名字模糊搜索得到用户集
     *
     * @param  name
     * @return
     * @throws SQLException
     */
    List<User> getUsersByName(String name) throws SQLException;

    /**
     * 插入User
     *
     * @param name
     * @param password
     * @param img
     * @param sign
     * @return
     * @throws SQLException
     */
    int addUser(String name,String password,String img,String sign) throws SQLException;

    /**
     * 根据编号删除缓存
     *
     * @param id
     * @return
     * @throws SQLException
     */
    int deleteUser(int id) throws SQLException;

    /**
     * 通过id查询用户权限
     *
     * @param id
     * @return
     * @throws SQLException
     */
    int getUserRoleById(int id) throws SQLException;

    /**
     * 通过id查询用户权限
     *
     * @param user
     * @return
     * @throws SQLException
     */
    int updateUser(User user) throws SQLException;

}
