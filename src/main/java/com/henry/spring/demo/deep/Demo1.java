package com.henry.spring.demo.deep;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * @author heyong
 * @date 2021/3/22 13:48
 */
public class Demo1 {

  public static void main(String[] args) {
    // 编程式使用spring ioc

    // 定义读取resource
    ClassPathResource resource = new ClassPathResource("spring-bean-config.xml");
    // 定义beanFactory
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    // 注入注册器
    XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

    reader.loadBeanDefinitions(resource);

    System.out.println(beanFactory.getBean("myTestBean").toString());;

  }

}
