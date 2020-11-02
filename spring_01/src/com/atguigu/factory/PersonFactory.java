package com.atguigu.factory;

import com.atguigu.pojo.Person;

/**
 * @author oono
 * @date 2020 11 02
 */
public class PersonFactory {

    public static Person createPerson(){
        return new Person(15,"工厂静态方法","110",18);
    }

    public Person createPerson2(){
        return new Person(16,"工厂实例方法","110",19);
    }

}
