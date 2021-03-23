package com.henry.spring.controller;

import com.henry.spring.pojo.User;
import com.henry.spring.pojo.UserReposition;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author heyong
 * @date 2020/11/12 10:58
 */
public class UserController {

  public static void main(String[] args) {

    // 打印User
    BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:user-config.xml");
    User user = (User) beanFactory.getBean("user");

    System.out.println("user:" + user);


    UserReposition reposition = beanFactory.getBean(UserReposition.class);
    System.out.println("userReposition:" + reposition);

    System.out.println("beanFactory:" + beanFactory);

    System.out.println("reposition.getBeanFactory() == beanFactory ? " + (reposition.getBeanFactory() == beanFactory));

  }
}
