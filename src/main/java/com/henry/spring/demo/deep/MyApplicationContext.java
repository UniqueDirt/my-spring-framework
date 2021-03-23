package com.henry.spring.demo.deep;

import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author heyong
 * @date 2021/3/23 14:29
 */
public class MyApplicationContext extends FileSystemXmlApplicationContext {


  public static void main(String[] args) {
    new MyApplicationContext().test("hello");
  }

  public void test(String... msg) {
    System.out.println("1:" + msg);
  }

  public void test(String msg) {
    System.out.println("2:" + msg);
  }
}
