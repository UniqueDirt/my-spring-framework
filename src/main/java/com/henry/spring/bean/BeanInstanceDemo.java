package com.henry.spring.bean;

import com.henry.spring.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author heyong
 * @date 2020/11/16 19:45
 */
public class BeanInstanceDemo {

  public static void main(String[] args) {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:bean-instance-config.xml");

    User userByStaticMethod = (User) applicationContext.getBean("create-user-by-static-method");

    User userByInstanceMethod = (User) applicationContext.getBean("create-user-by-instance-method");

    User userByFactoryBean = (User) applicationContext.getBean("create-user-by-factory-method");

    System.out.println("user:" + userByStaticMethod);

    System.out.println("user2:" + userByInstanceMethod);

    System.out.println("user3:" + userByFactoryBean);

  }
}
