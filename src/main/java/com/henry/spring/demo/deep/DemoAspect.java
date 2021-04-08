package com.henry.spring.demo.deep;

/**
 * @author heyong
 * @date 2021/4/7 10:18
 */
public class DemoAspect {


  public void before () {
    System.out.println("before method exec...");
  }


  public void after () {
    System.out.println("after method exec...");
  }
}
