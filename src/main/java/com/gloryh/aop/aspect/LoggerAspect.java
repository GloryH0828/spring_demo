package com.gloryh.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 日志打印切面类
 *
 * @author 黄光辉
 * @since 2020/8/28
 **/
@Component
@Aspect
public class LoggerAspect {

    @Before("execution(public int com.gloryh.aop.utils.impl.CalImpl.*(..))")
    public void before(JoinPoint joinPoint){
        //首先获取方法名
        String name =joinPoint.getSignature().getName();
        //获取参数
        String args =Arrays.toString(joinPoint.getArgs());
        System.out.println(name+"方法的参数是: "+ args);
    }
    @After("execution(public int com.gloryh.aop.utils.impl.CalImpl.*(..))")
    public void after(JoinPoint joinPoint){
        //首先获取方法名
        String name =joinPoint.getSignature().getName();
        System.out.println(name+"方法执行完毕");
    }
    @AfterReturning(value = "execution(public int com.gloryh.aop.utils.impl.CalImpl.*(..))",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        //首先获取方法名
        String name =joinPoint.getSignature().getName();

        System.out.println(name+"方法的结果是: "+ result);
    }
    @AfterThrowing(value = "execution(public int com.gloryh.aop.utils.impl.CalImpl.*(..))",throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint ,Exception exception){
        String name =joinPoint.getSignature().getName();

        System.out.println(name+"方法的执行出现异常:\n "+exception );
    }


}
