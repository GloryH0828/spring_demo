package com.gloryh.ioc;

import com.gloryh.entity.Student;

/**
 * 测试手写的ioc实现原理
 *
 * @author 黄光辉
 * @since 2020/8/26
 **/
public class Test {
  public static void main(String[] args) {
    ApplicationContext applicationContext =new ClassPathXmlApplicationContext("spring.xml");
    Student student =(Student) applicationContext.getBean("student");
    System.out.println(student);
  }
}
