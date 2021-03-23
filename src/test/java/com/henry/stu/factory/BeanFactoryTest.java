package com.henry.stu.factory;

import com.henry.stu.extend.MyXmlBeanFactory;
import com.henry.spring.pojo.Car;
import com.henry.spring.pojo.CarFactoryBean;
import com.henry.spring.pojo.MyTestBean;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

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

  @Test
  public void getDocument() throws ParserConfigurationException, IOException, SAXException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = factory.newDocumentBuilder();
    Document document = docBuilder.parse("");
  }

  @Test
  public void getInputStream() throws IOException {
    Resource resource = new ClassPathResource("spring-bean-config.xml");
    InputStream inputStream = resource.getInputStream();
    byte b[] = new byte[1024];
    inputStream.read(b);
    System.out.println(new String(b));
  }

  /**
   * 扩展： 在bean解析前后自定义 操作
   */
  @Test
  public void MySimpleLoad() {
    BeanFactory beanFactory = new MyXmlBeanFactory(new ClassPathResource("spring-bean-config.xml"));
    MyTestBean bean = (MyTestBean) beanFactory.getBean("myTestBean");
    System.out.println("name: " + bean.getName() + "; nickname: " + bean.getNickname());
    Assert.assertEquals("Hello bean", bean.getName());
  }

  @Test
  public void MyCarBean() throws Exception {
    BeanFactory beanFactory = new MyXmlBeanFactory(new ClassPathResource("spring-bean-config.xml"));
    Car car = (Car) beanFactory.getBean("car");
    CarFactoryBean carFactoryBean  = (CarFactoryBean) beanFactory.getBean("&car");
    System.out.println("car info:" + car.toString());
    System.out.println("car factory info:" + carFactoryBean.toString());
    System.out.println("factory car info:" + carFactoryBean.getObject());
  }

  @Test
  public void MylTestOfApplication() {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-bean-config.xml");
  }
}
