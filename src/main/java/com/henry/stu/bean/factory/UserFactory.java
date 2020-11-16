package com.henry.stu.bean.factory;

import com.henry.stu.pojo.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author heyong
 * @date 2020/11/16 20:04
 */
public class UserFactory implements FactoryBean {

  @Override
  public Object getObject() throws Exception {
    User user = new User();
    user.setId(3);
    user.setName("通过FactoryBean实例化Bean");
    return user;
  }

  @Override
  public Class<?> getObjectType() {
    return User.class;
  }
}
