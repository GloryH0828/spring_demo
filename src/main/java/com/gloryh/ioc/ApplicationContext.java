package com.gloryh.ioc;

/**
 * 手动实现IoC实现原理
 *
 * @author 黄光辉
 * @since 2020/8/26
 **/
public interface ApplicationContext {
  /**
   * @param id
   * @return Object
   */
  public Object getBean(String id);
}
