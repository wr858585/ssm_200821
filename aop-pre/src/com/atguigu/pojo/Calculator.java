package com.atguigu.pojo;

import com.atguigu.util.LogUtils;

/**
 * @author oono
 * @date 2020 11 03
 */
public class Calculator implements Calculate{

    @Override
    public int add(int num1, int num2) {
        try{
            LogUtils.logBefore("add", num1, num2);
            int result = num1 + num2;
            LogUtils.logAfter("add", result);
            return result;
        } catch(Exception e){
            LogUtils.logAfterThrowing("add", num1, num2);
            throw new RuntimeException(e);
        }
    }

    @Override
    public int add(int num1, int num2, int num3) {
        try{
            LogUtils.logBefore("add", num1, num2, num3);
            int result = num1 + num2 + num3;
            LogUtils.logAfter("add", result);
            return result;
        } catch(Exception e){
            LogUtils.logAfterThrowing("add", num1, num2, num3);
            throw new RuntimeException(e);
        }
    }

    @Override
    public int div(int num1, int num2) {
        try{
            LogUtils.logBefore("div", num1, num2);
            int result = num1/num2;
            LogUtils.logAfter("div", result);
            return result;
        } catch (Exception e){
            LogUtils.logAfterThrowing("div", num1, num2);
            throw new RuntimeException(e);
        }
    }
}
