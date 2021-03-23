package com.henry.spring.pojo;

import org.springframework.beans.factory.BeanFactory;


/**
 * @author heyong
 * @date 2020/11/12 10:56
 */
public class UserReposition {

  private User user;

  private BeanFactory beanFactory;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public BeanFactory getBeanFactory() {
    return beanFactory;
  }

  public void setBeanFactory(BeanFactory beanFactory) {
    this.beanFactory = beanFactory;
  }


  @Override
  public String toString() {
    return "UserReposition{" +
            "user=" + user +
            ", beanFactory=" + beanFactory +
            '}';
  }
}
