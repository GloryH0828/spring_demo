package com.gloryh.test;

import com.gloryh.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试5
 *
 * @author 黄光辉
 * @since 2020/8/27
 */
public class Test5 {
  public static void main(String[] args) {
    ApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("spring-autowire.xml");
    Person person = (Person) applicationContext.getBean("person");
    System.out.println(person);
  }
}
