package com.atguigu.dao;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author oono
 * @date 2020 11 03
 */

@Repository
public class UserDao extends BaseDao<User>{
    
    @Override
    public void saveEntity(User entity) {
        System.out.println("UserDao保存：" + entity);
    }
}
