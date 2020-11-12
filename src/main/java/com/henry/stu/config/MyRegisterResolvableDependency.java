package com.henry.stu.config;

import com.henry.stu.service.MyCar;
import com.henry.stu.service.impl.Bwm;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author heyong
 * @date 2020/11/12 16:04
 */
public class MyRegisterResolvableDependency implements BeanFactoryPostProcessor {

  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    beanFactory.registerResolvableDependency(MyCar.class, new Bwm());
  }
}
