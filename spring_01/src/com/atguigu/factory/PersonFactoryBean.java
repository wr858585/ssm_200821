package com.atguigu.factory;

import com.atguigu.pojo.Person;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author oono
 * @date 2020 11 02
 */
public class PersonFactoryBean implements FactoryBean<Person> {

    /**
     * getObject()方法用于在Spring容器获取对象时调用，好创建对象
     * @return
     * @throws Exception
     */
    @Override
    public Person getObject() throws Exception {
        return new Person(17,"FactoryBean接口来创建对象","110",18);
    }

    /**
     *
     * @return
     */
    @Override
    public Class<Person> getObjectType() {
        return Person.class;
    }
}
