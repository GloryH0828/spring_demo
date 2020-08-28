package com.gloryh.entity;

import lombok.Data;

/**
 * Person实体类
 *
 * @author 黄光辉
 * @since 2020/8/27
 **/
@Data
public class Person {
    private long id;
    private String name;
    private Car car;
}
