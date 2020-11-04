package com.atguigu.dao;

import org.springframework.stereotype.Repository;

/**
 * @author oono
 * @date 2020 11 03
 */
@Repository
public abstract class BaseDao<T> {

    public abstract void saveEntity(T entity);

}
