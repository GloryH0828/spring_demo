package com.gloryh.aop.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 实现创建动态代理类功能
 *
 * @author 黄光辉
 * @since 2020/8/28
 **/
public class MyInvocationHandler implements InvocationHandler {
    //接收委托对象
    private Object object =null;

    //返回代理对象
    public Object bind(Object obj){
        this.object=obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this );
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //解耦合，将日志代码分离出来
        System.out.println(method.getName()+"方法的参数是"+ Arrays.toString(args));
        //通过反射调用业务代码
        Object result = method.invoke(this.object,args);
        System.out.println(method.getName()+"方法的结果是:"+result);
        return result;
    }
}
