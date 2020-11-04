package com.atguigu.pojo;

import org.springframework.stereotype.Component;

/**
 * @author oono
 * @date 2020 11 03
 */
@Component
public class Calculator implements Calculate{

    @Override
    public int add(int num1, int num2) {
        System.out.println("执行目标方法 public int add(int num1, int num2)");
        int result = num1 + num2;
        return result;
    }

    @Override
    public int add(int num1, int num2, int num3) {
        System.out.println("执行目标方法 public int add(int num1, int num2, int num3)");
        int result = num1 + num2 + num3;
        return result;
    }

    @Override
    public int div(int num1, int num2) {
        System.out.println("执行目标方法 public int div(int num1, int num2)");
        int result = num1/num2;
        return result;
    }
}
