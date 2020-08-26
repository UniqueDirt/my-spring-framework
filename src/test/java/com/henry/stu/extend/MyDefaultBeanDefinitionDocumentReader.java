package com.henry.stu.extend;

import org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader;
import org.w3c.dom.Element;

/**
 * @author heyong
 * @date 2020/8/26 14:14
 */
public class MyDefaultBeanDefinitionDocumentReader extends DefaultBeanDefinitionDocumentReader {

  @Override
  protected void preProcessXml(Element root) {
    System.out.println("preProcessXml ...");
    super.preProcessXml(root);
  }

  @Override
  protected void postProcessXml(Element root) {
    System.out.println("postProcessXml ...");
    super.postProcessXml(root);
  }
}
