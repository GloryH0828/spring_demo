package com.gloryh.factory;

import com.gloryh.entity.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * 静态工厂类
 *
 * @author 黄光辉
 * @since 2020/8/27
 **/
public class StaticCarFactory {
    private static Map<Long, Car> cars;
    static{
        cars = new HashMap<Long, Car>();
        cars.put(1L,new Car(1L,"宝马"));
        cars.put(2L,new Car(2L,"奔驰"));
    }
    public static Car getCar(Long id){
        return cars.get(id);
    }
}
