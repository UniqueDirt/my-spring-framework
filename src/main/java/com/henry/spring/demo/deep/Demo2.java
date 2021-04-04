package com.henry.spring.demo.deep;

import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author heyong
 * @date 2021/3/22 14:41
 */
public class Demo2 {

  public static void main(String[] args) {

    FileSystemXmlApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:spring-bean-config.xml");

    System.out.println(applicationContext.getBean("myTestBean").toString());

    ((DemoService) applicationContext.getBean("demoService")).eat();

    System.out.println(applicationContext.getBean("car"));

    System.out.println(applicationContext.getBean("&car"));


  }
}
