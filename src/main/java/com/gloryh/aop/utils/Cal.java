package com.gloryh.aop.utils;

/**
 * 计算器接口，实现加减乘除
 *
 * @author 黄光辉
 * @since 2020/8/28
 **/
public interface Cal {
    public int add (int num1,int num2);
    public int sub (int num1,int num2);
    public int mul (int num1,int num2);
    public int div (int num1,int num2);

}
