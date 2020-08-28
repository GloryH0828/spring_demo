package com.gloryh.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试2
 *
 * @author 黄光辉
 * @since 2020/8/26
 **/
public class Test2 {
  public static void main(String[] args) {
      ApplicationContext applicationContext =new ClassPathXmlApplicationContext("spring-dependency.xml");

  }
}
