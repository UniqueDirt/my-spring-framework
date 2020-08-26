package com.henry.stu.extend;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;

/**
 * @author heyong
 * @date 2020/8/26 14:18
 */
public class MyXmlBeanFactory extends DefaultListableBeanFactory {


  private final XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(this);

  /**
   * Create a new XmlBeanFactory with the given resource,
   * which must be parsable using DOM.
   * @param resource XML resource to load bean definitions from
   * @throws BeansException in case of loading or parsing errors
   */
  public MyXmlBeanFactory(Resource resource) throws BeansException {
    this(resource, null);
  }

  /**
   * Create a new XmlBeanFactory with the given input stream,
   * which must be parsable using DOM.
   * @param resource XML resource to load bean definitions from
   * @param parentBeanFactory parent bean factory
   * @throws BeansException in case of loading or parsing errors
   */
  public MyXmlBeanFactory(Resource resource, BeanFactory parentBeanFactory) throws BeansException {
    super(parentBeanFactory);
    // 设置成自己定义的织入类
    this.reader.setDocumentReaderClass(MyDefaultBeanDefinitionDocumentReader.class);
    this.reader.loadBeanDefinitions(resource);
  }
}
