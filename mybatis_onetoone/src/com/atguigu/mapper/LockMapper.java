package com.atguigu.mapper;

import com.atguigu.pojo.Lock;

/**
 * @author oono
 * @date 2020 10 28
 */
public interface LockMapper {

    /**
     * 根据lock编号查询lock[pojo]对象信息（不常用列）
     * @param id：lock的编号
     * @return
     */
    Lock queryLockById(Integer id);

}
