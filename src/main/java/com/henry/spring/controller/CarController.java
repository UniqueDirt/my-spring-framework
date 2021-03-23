package com.henry.spring.controller;

import com.henry.spring.service.MyCar;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author heyong
 * @date 2020/11/12 15:48
 */
public class CarController {

  public static void main(String[] args) {

    BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:user-config.xml");

    MyCar myCar = (MyCar)beanFactory.getBean(MyCar.class);
    System.out.println("myCar:" + myCar);
  }
}
