package com.atguigu.mapper;

import com.atguigu.pojo.Key;

/**
 * @author oono
 * @date 2020 10 28
 */
public interface KeyMapper {

    /**
     * 根据Key编号查询key[pojo]信息（常用列）
     * @param id：key的编号
     * @return
     */
    Key queryKeyById(Integer id);

    /**
     * 两次查询，一次查key（常用列表），一次查lock（不常用表）
     * @param id：key的编号
     * @return
     */
    Key queryKeyByIdForTwoSteps(Integer id);

}
