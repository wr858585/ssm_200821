package com.atguigu.service;

import com.atguigu.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author oono
 * @date 2020 11 03
 */
@Service
public abstract class BaseService<T> {

    @Autowired
    private BaseDao<T> baseDao;

    public void saveEntity(T entity){
        baseDao.saveEntity(entity);
    }

}
