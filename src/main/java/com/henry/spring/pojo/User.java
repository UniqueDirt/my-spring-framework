package com.henry.spring.pojo;

/**
 * @author heyong
 * @date 2020/11/12 10:54
 */
public class User {

  private Integer id;

  private String name;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static User getUser() {
    User user = new User();
    user.setId(1);
    user.setName("通过静态方法实例化Bean");
    return user;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
  }

}
