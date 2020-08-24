package com.henry.stu.factory;

import com.henry.stu.pojo.MyTestBean;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author heyong
 * @date 2020/8/24 15:56
 */
public class BeanFactoryTest {

  @Test
  public void testSimpleLoad() {
    BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring-bean-config.xml"));
    MyTestBean bean = (MyTestBean) beanFactory.getBean("myTestBean");
    System.out.println("bean content: " + bean.getName());
    Assert.assertEquals("Hello bean", bean.getName());
  }
}
