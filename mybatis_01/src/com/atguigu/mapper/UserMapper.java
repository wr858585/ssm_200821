package com.atguigu.mapper;

import com.atguigu.pojo.User;
import org.apache.ibatis.annotations.Param;

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

    List<User> queryUsersBySexOrName(@Param("sex") Integer sex, @Param("name") String name);

    List<User> queryUsersLikeName(@Param("name") String name);

}
