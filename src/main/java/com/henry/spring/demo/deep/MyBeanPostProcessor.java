package com.henry.spring.demo.deep;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

/**
 * @author heyong
 * @date 2021/4/7 14:38
 */
public class MyBeanPostProcessor implements BeanPostProcessor, Ordered {

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    System.out.println("自定义 bean post processor before method...  print beanName: " + beanName);
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    System.out.println("自定义 bean post processor after method...  print beanName: " + beanName);
    return bean;
  }

  @Override
  public int getOrder() {
    return 0;
  }
}
