package com.gloryh.aop.utils.impl;

import com.gloryh.aop.utils.Cal;
import org.springframework.stereotype.Component;

/**
 * Cal接口的实现类，实现加减乘除算法
 *
 * @author 黄光辉
 * @since 2020/8/28
 */
@Component
public class CalImpl implements Cal {
  public int add(int num1, int num2) {

    return num1 + num2;
  }

  public int sub(int num1, int num2) {

    return num1 - num2;
  }

  public int mul(int num1, int num2) {

    return num1 * num2;
  }

  public int div(int num1, int num2) {

    return num1 / num2;
  }
}
