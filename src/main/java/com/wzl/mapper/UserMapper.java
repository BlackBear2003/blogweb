package com.wzl.mapper;

import com.wzl.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {
    /**
     * 根据用户id查询
     *
     * @param id
     * @return
     */
    User getUserById(int id);

    /**
     * 根据用户名模糊查询用户
     *
     * @param name
     * @return
     */
    List<User> getUsersByName(String name);

    /**
     * 添加用户
     *
     * @param user
     */
    int addUser(User user);

    /**
     * 删除用户
     *
     * @param id
     */
    int deleteUser(int id);

    /**
     * 添加用户
     *
     * @param user
     */
    int updateUser(User user);

    int getUserRoleById(int id);

}
