package com.atguigu.util;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author oono
 * @date 2020 11 03
 */

//@Aspect表示切片类 --> 带有advice（增强）的类
@Aspect
@Component
public class LogUtils {

    /**
     * @Before注解表示前置通知
     * execution(public int com.atguigu.pojo.Calculator.add(int,int)叫切入点表达式
     */
    @Before(value = "pointcut1()")
    /**
     * JoinPoint joinPoint表示连接点。类：org.aspectj.lang.JoinPoint
     * joinPoint.getSignature().getName()获取方法名
     * joinPoint.getArgs()获取方法的参数
     */
    public static void logBefore(JoinPoint joinPoint) {
        System.out.println("前置通知：" + joinPoint.getSignature().getName() + "，参数是：" + Arrays.asList(joinPoint.getArgs()));
    }

    /**
     * @After注解表示后置通知
     */
    @After(value = "pointcut1()")
    public static void logAfter(){
        System.out.println("后置通知：logAfter()，参数是：");
    }
       
    @AfterReturning(value = "pointcut1()", returning = "result")
    public static void logAfterReturning(JoinPoint joinpoint, Object result){
        System.out.println("返回通知：" + joinpoint.getSignature().getName() + "，结果是：" + result);
    }

    @AfterThrowing(value = "pointcut1()", throwing = "exception")
    public static void logAfterThrowing(JoinPoint joinPoint, Exception exception){
        System.out.println("异常通知：" + joinPoint.getSignature().getName() + "，异常是：" + exception);
    }


    @Around(value = "execution(public * com.atguigu..Calculator.div(..))")
    public static Object around(ProceedingJoinPoint proceedingJoinPoint){
        //一个环绕通知，可以做@before,@after,@afterReturning,@afterThrowing四件事情
        Object result = null;
        try{
            try{
                System.out.println("环绕前置通知");
                result = proceedingJoinPoint.proceed();
            } finally {
                System.out.println("环绕后置通知");
            }
            System.out.println("环绕返回通知");
            return result;
        } catch(Throwable throwable){
            throwable.getStackTrace();
            System.out.println("环绕异常通知");
            throw new RuntimeException(throwable);
        }
    }

    @Pointcut(value = "execution(public * com..Calculator.*(..))")
    public static void pointcut1(){};

}
