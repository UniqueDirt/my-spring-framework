package com.henry.stu.pojo;

/**
 * @author heyong
 * @date 2020/8/24 15:53
 */
public class MyTestBean {

  private String name;

  private String nickname;

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

  public MyTestBean(String name) {
    this.name = name;
  }

  public MyTestBean(String name, String nickname) {
    this.name = name;
    this.nickname = nickname;
  }
}
