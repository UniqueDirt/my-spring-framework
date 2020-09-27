package com.henry.stu.demo.xmlResolver;

import com.henry.stu.pojo.Car;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanDefinitionApplication {

  public static void main(String[] args) {

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-simple-bean-config.xml");

    Car car = (Car)context.getBean("car");

    System.out.println(car.getBrand());
  }
}
