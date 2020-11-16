package com.henry.stu.bean.factory;

import com.henry.stu.pojo.User;

/**
 * @author heyong
 * @date 2020/11/16 19:53
 */
public interface UserInstanceFactory {

  default User getUser() {
    User user = new User();
    user.setId(2);
    user.setName("通过实例方法实例化Bean");
    return user;
  }
}
