package com.atguigu.test;

import com.atguigu.pojo.Calculate;
import com.atguigu.pojo.Calculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author oono
 * @date 2020 11 03
 */

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTest {

    @Autowired
    private Calculate calculate;

    @Test
    public void test(){
//        System.out.println(calculate.add(1, 2));
        System.out.println(calculate.add(1, 2, 3));
//        System.out.println(calculate.div(1, 2));
    }


}
