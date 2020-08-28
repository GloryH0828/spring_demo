package com.gloryh.test;

import com.gloryh.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO
 *
 * @author 黄光辉
 * @since 2020/8/26
 */
public class Test {
  public static void main(String[] args) {
    //加载配置文件
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    User  user=(User) applicationContext.getBean("user");
    System.out.println(user);
  }
}
