package com.atguigu.proxy;

import com.atguigu.pojo.Calculate;
import com.atguigu.pojo.Calculator;
import com.atguigu.util.LogUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author oono
 * @date 2020 11 03
 */
public class JdkProxyFactory {

    public static Object createJdkProxy(Object target, InvocationHandler invocationHandler){
        /**
         *         * Proxy是jdk中反射包下提供的一个工具类，专门用来创建代理对象<br/>
         *          * newProxyInstance()是创建一个代理对象实例<br/>
         *          *  第一个参数是，类加载器<br/>
         *          *  第二个参数是，目标对象和代理对象都需要统一实现的接口 <br/>
         *          *  第三个参数是：InvocationHandler 接口实现类。它有一个方法invoke() 这个方法在每次调用代理对象方法的时候就会自动调用<br/>
         *          *  InvocationHandler#invoke()方法里需要干两件事情：  <br/>
         *          *      1 调用目标对象的方法 <br/>
         *          *      2 执行增强的操作 <br/>
         */
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                invocationHandler);
    }

    static class LogInvocationHandler implements InvocationHandler{

        //目标对象
        Object target;

        public LogInvocationHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            try{
                LogUtils.logBefore(method.getName(),args);

                //调用目标对象target的方法（其他的均为proxy的增强）
                Object result = method.invoke(target,args);

                LogUtils.logAfter(method.getName(),result);
                return result;
            } catch (Exception e){
                LogUtils.logAfterThrowing(method.getName(),e);
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Calculate calculate = new Calculator();
//        calculate.add(1,2,3);
//        calculate.add(1,2);
//        calculate.div(1,0);
        Calculate proxy = (Calculate)createJdkProxy(calculate,new LogInvocationHandler(calculate));
        proxy.add(1,2);
        proxy.add(1,2,3);
        proxy.div(1,0);
    }

}
