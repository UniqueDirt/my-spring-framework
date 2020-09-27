package com.henry.stu.reflect;

import com.henry.stu.pojo.Car;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author heyong
 * @date 2020/9/16 15:57
 */
public class ReflectTest {

  @Test
  public void getmsgByReflect () throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
    Car car = new Car();
    car.setBrand("bm");
    car.setName("hy");
    Class class1 = car.getClass();
    System.out.println("class1 name: " + class1.getName());

    Class class2 = Car.class;
    System.out.println("class1 == class2:" + (class1 == class2));

    Class class3 = Class.forName("com.henry.stu.pojo.Car");
    System.out.println("class2 == class3:" +  (class3 == class2));

    Car car2 = new Car();
    car2.setBrand("bc");
    Class class4 = car.getClass();
    System.out.println("class1 == class4:" +  (class1 == class4));

    Field[] fields = class1.getFields();
    Field brandField = class1.getDeclaredField("name");
    brandField.setAccessible(true);
    System.out.println("class1.brand: " + brandField.get(car));
//    System.out.println("class4.brand: " + class4.getField("brand"));
//    System.out.println("class1.brand == class4.brand: " + (class1.getField("brand") == class4.getField("brand")));
  }
}
