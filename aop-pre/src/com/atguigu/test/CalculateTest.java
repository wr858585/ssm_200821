package com.atguigu.test;

import com.atguigu.pojo.Calculator;
import com.atguigu.util.LogUtils;

/**
 * @author oono
 * @date 2020 11 03
 */
public class CalculateTest {

    public static void main(String[] args) {

        /**
         * 需求1：给计算器的每一个方法都加上日志操作，记录下运算名和形参
         * 需求2：记录每个计算结果之后的结果
         * 需求3：如果出现异常，记录异常信息
         */

        Calculator calculator = new Calculator();
        calculator.add(1,2);
        calculator.add(1,2,3);
        calculator.div(1,0);
    }

}
