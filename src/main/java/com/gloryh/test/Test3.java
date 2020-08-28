package com.gloryh.test;

import com.gloryh.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试3
 *
 * @author 黄光辉
 * @since 2020/8/26
 */
public class Test3 {
  public static void main(String[] args) {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-p.xml");
    Student student = (Student) applicationContext.getBean("student");
    System.out.println(student);
  }
}
