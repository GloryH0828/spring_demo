package com.gloryh.test;

import com.gloryh.entity.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试四
 *
 * @author 黄光辉
 * @since 2020/8/27
 */
public class Test4 {
  public static void main(String[] args) {
    // 调用IoC配置的工厂类获取bean
    ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-factory.xml");
    Car car =(Car) applicationContext.getBean("car2");
    System.out.println(car);


  }
}
