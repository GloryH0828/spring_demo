package com.gloryh.entity;

import lombok.Data;

/**
 * User实体类
 *
 * @author 黄光辉
 * @since 2020/8/26
 */
@Data
public class User {
  private long id;
  private String name;
  private int age;

  public User() {
    System.out.println("创建了User对象");
  }
}
