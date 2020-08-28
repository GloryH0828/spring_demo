package com.gloryh.aop.test;

import com.gloryh.aop.utils.MyInvocationHandler;
import com.gloryh.aop.utils.impl.CalImpl;
import com.gloryh.aop.utils.Cal;

/**
 * 计算器测试方法
 *
 * @author 黄光辉
 * @since 2020/8/28
 **/
public class Test {
  public static void main(String[] args) {
      //首先实例化一个委托对象
      Cal cal = new CalImpl();
      //然后实例化MyInvocationHandler方法
      MyInvocationHandler myInvocationHandler =new MyInvocationHandler();
      //根据MyInvocationHandler方法得到代理对象
      Cal cal1 = (Cal) myInvocationHandler.bind(cal);
      //使用代理对象实现方法
      cal1.add(1,1);
      cal1.sub(2,1);
      cal1.mul(2,5);
      cal1.div(8,4);

  }
}
