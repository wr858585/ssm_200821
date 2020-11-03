package com.atguigu.processor;

import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author oono
 * @date 2020 11 02
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("初始化前作了一些事");
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName){
        System.out.println("初始化之后做了一些事");
        return bean;
    }


}
