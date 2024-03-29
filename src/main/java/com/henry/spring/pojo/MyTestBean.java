package com.henry.spring.pojo;

/**
 * @author heyong
 * @date 2020/8/24 15:53
 */
public class MyTestBean {

  private String name;

  private String nickname;

  private User user;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public MyTestBean() {

  }

  public MyTestBean(String name, String nickname) {
    this.name = name;
    this.nickname = nickname;
  }

  @Override
  public String toString() {
    return "MyTestBean{" +
            "name='" + name + '\'' +
            ", nickname='" + nickname + '\'' +
            ", user=" + user +
            '}';
  }
}
