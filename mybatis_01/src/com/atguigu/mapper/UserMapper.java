package com.atguigu.mapper;

import com.atguigu.pojo.User;

import java.util.List;

/**
 * @author oono
 * @date 2020 10 27
 */
public interface UserMapper {

    User queryUserById(Integer id);

    List<User> queryUsers();

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(Integer id);

}
