package com.atguigu.tx.service;

import com.atguigu.tx.dao.BookDao;
import com.atguigu.tx.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(propagation = Propagation.REQUIRED)
    public void multiUpdate(){
        bookDao.updateBook();
        int mistake = 12/0;
        userDao.updateUser();
    }

}
