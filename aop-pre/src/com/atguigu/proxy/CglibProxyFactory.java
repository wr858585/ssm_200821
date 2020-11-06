package com.atguigu.proxy;

import com.atguigu.pojo.Calculate;
import com.atguigu.pojo.Calculator;
import com.atguigu.util.LogUtils;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import sun.rmi.runtime.Log;

import java.lang.reflect.Method;

/**
 * @author oono
 * @date 2020 11 03
 */
public class CglibProxyFactory {

    public static Object createCglibProxy(Object target, MethodInterceptor methodInterceptor){

        //创建一个用于增强的工具类
        Enhancer enhancer = new Enhancer();

        //在给定的class字节码基础上，生成一个代理
        enhancer.setSuperclass(target.getClass());

        /**
         * methodIntercept接口，也是用于增强的接口
         * 每次调用cglib代理方法时，都会执行MethodInterception#intercept()
         * 即，我们需要在MethodInterceptor#intercept()中做两件事情：
         * 1. 调用目标对象的方法
         * 2. 增强
         */
        enhancer.setCallback(methodInterceptor);

        //创建代理对象
        return enhancer.create();
    }

    static class LogMethodInterceptor implements MethodInterceptor{

        Object target;

        public LogMethodInterceptor(Object target){
            this.target = target;
        }

        @Override
        public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            try{
                //前置增强 || 前置通知
                LogUtils.logBefore(method.getName(), args);
                //调用目标方法
                Object result = method.invoke(target, args);
                //后置增强 || 结果通知
                LogUtils.logAfter(method.getName(), result);
                return result;
            } catch (Exception e){
                //异常增强 || 异常通知
                LogUtils.logAfterThrowing(method.getName(), e);
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {

        Calculate calculate = new Calculator();

        Calculate cglibProxy = (Calculate)createCglibProxy(calculate, new LogMethodInterceptor(calculate));

        cglibProxy.add(1,2,3);
        cglibProxy.add(1,2);
        cglibProxy.div(1,0);
    }

}
