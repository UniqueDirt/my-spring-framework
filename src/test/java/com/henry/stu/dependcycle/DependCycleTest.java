package com.henry.stu.dependcycle;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependCycleTest {

  @Test
  public void cycleTest () {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("depeed-cycle-config.xml");
    TestA a = (TestA) context.getBean("testA");
    System.out.println("a: " + a.toString());
  }
}
