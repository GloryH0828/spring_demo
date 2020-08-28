package com.gloryh.ioc;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Application接口实现类，用于手动实现IoC原理
 *
 * @author 黄光辉
 * @since 2020/8/26
 */
public class ClassPathXmlApplicationContext implements ApplicationContext {
  private Map<String, Object> ioc = new HashMap<String, Object>();

  public ClassPathXmlApplicationContext(String path) {
    try {
      SAXReader saxReader = new SAXReader();
      Document document = saxReader.read("./src/main/resources/" + path);
      Element root = document.getRootElement();
      Iterator<Element> iterator = root.elementIterator();
      while (iterator.hasNext()) {
        Element element = iterator.next();
        String id =element.attributeValue("id");
        String className = element.attributeValue("class");
        System.out.println("当前bean的id为："+id);
        System.out.println("对应的实体类全限定类名为："+className);
        //接下来通过反射机制创建对象
        Class clazz = Class.forName(className);
        //获取无参构造函数
        Constructor constructor=clazz.getConstructor();
        System.out.println("当前实体类的为无参构造方法为："+constructor);
        //调用函数创建目标对象
        Object object=constructor.newInstance();
        System.out.println("当前实体类的初始化对象为："+object);
        //给目标对象赋值（遍历下一个节点）
        Iterator<Element> beanIterator =element.elementIterator();
        while (beanIterator.hasNext()){
          Element property =beanIterator.next();
          String name =property.attributeValue("name");
          String valueStr =property.attributeValue("value");
          //取出ref标签
          String ref=property.attributeValue("ref");
          if(ref == null){
            System.out.println("由于当前property的ref标签为null，执行普通赋值操作");
            getValue(name,valueStr,clazz,object);
          }else{
            System.out.println("由于当前property的ref标签不为null，需要加载bean");
            //这里可以使用递归进行赋值，或者在getBean方法中调用进行赋值
          }
          ioc.put(id,object);
        }

      }
      System.out.println(ioc);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Object getBean(String id) {
    return ioc.get(id);
  }
  public Method getValue(String name ,String valueStr,Class clazz,Object object){
    //需要将name对应字符串首字符变大写，然后添加set（如id对应构造方法setId（））
    String methodName ="set"+name.substring(0,1).toUpperCase()+name.substring(1);
    System.out.println("当前参数对应的set方法为为："+methodName);
    //通过反射获取方法以及所需要的参数类型
    Field field = null;
    try {
      field = clazz.getDeclaredField(name);
    } catch (NoSuchFieldException e) {
      e.printStackTrace();
    }
    System.out.println("当前set方法的参数类型为："+field.getType().getName());
    Method method = null;
    try {
      method = clazz.getDeclaredMethod(methodName,field.getType());
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
    System.out.println("当前实体类的完整set方法名为："+method);
    //给方法赋值,直接使用valueStr的话会抛出异常（类型不匹配），因为valueStr为String类型。
    //要根据成员变量类型对valueStr进行数据转换
    Object value=null;
    if(field.getType().getName() == "long"){
      value  =Long.parseLong(valueStr);
    }
    if(field.getType().getName() == "int"){
      value = Integer.parseInt(valueStr);
    }
    if (field.getType().getName() == "java.lang.String"){
      value=valueStr;
    }
    //类型转换完成，进行赋值
    try {
      method.invoke(object,value);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
    return method;
  }
}
