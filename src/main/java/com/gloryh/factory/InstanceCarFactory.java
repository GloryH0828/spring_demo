package com.gloryh.factory;

import com.gloryh.entity.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * 实例工厂方法
 *
 * @author 黄光辉
 * @since 2020/8/27
 */
public class InstanceCarFactory {
  private Map<Long, Car> cars;

  public InstanceCarFactory() {
    cars = new HashMap<Long, Car>();
    cars.put(1L, new Car(1L, "宝马"));
    cars.put(2L, new Car(2L, "奔驰"));
  }

  public Car getCar(Long id) {
    return cars.get(id);
  }
}
