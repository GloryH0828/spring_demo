package com.gloryh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 学生实体类
 *
 * @author 黄光辉
 * @since 2020/8/26
 */
@Data
@AllArgsConstructor
public class Student {
  private long id;
  private String name;
  private int age;
  public Student() {
    System.out.println("创建了Student对象");
  }
}
