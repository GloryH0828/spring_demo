package com.gloryh.aop.test;

import com.gloryh.aop.utils.Cal;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试Spring 动态代理实现面向切面编程思想 ------AOP
 *
 * @author 黄光辉
 * @since 2020/8/28
 */
public class Test2 {
  public static void main(String[] args) {
    // 加载配置文件
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-aop.xml");
    // 获取代理对象
    Cal proxy = (Cal) applicationContext.getBean("calImpl");
    proxy.add(1, 1);
    proxy.sub(1, 1);
    proxy.mul(1, 1);
    proxy.div(1, 1);
  }
}
