package com.atguigu.tx.service;

import com.atguigu.tx.dao.BookDao;
import com.atguigu.tx.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author oono
 * @date 2020 11 05
 */
@Service
public class TransactionService {

    @Autowired
    BookDao bookDao;

    @Autowired
    UserDao userDao;

    public void multiUpdate(){
        bookDao.updateBook();
        userDao.updateUser();
    }

}
