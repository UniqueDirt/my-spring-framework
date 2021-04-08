package com.henry.spring.demo.deep;

/**
 * @author heyong
 * @date 2021/3/30 11:25
 */
public interface DemoService {

  default void eat() {
    System.out.println("eating ......");
  }

}
