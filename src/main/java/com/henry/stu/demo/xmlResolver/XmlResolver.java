package com.henry.stu.demo.xmlResolver;

import org.springframework.core.io.ClassPathResource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @author heyong
 */
public class XmlResolver {

  public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
    analyOfXmlParse();
  }

  public static void analyOfXmlParse() throws ParserConfigurationException, IOException, SAXException {
    ClassPathResource resource = new ClassPathResource("spring-simple-bean-config.xml");

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    // 启用校验
    factory.setNamespaceAware(true);
    factory.setValidating(true);
    factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");

    DocumentBuilder documentBuilder = factory.newDocumentBuilder();
    documentBuilder.setErrorHandler(new ErrorHandler() {
      public void warning(SAXParseException exception) throws SAXException {
        System.out.println("warn......");
      }

      public void error(SAXParseException exception) throws SAXException {
        throw exception;
      }

      public void fatalError(SAXParseException exception) throws SAXException {
        throw exception;
      }
    });

    // 增加本地解析/验证器  若是无法访问网络则通过本地xsd文件解析验证
    documentBuilder.setEntityResolver(new EntityResolver() {
      public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
        System.out.println("publicId:" + publicId);
        System.out.println("systemId:" + systemId);

        InputSource inputSource = null;
        ClassPathResource schema = null;
        if (systemId.equals("http://www.springframework.org/schema/beans/spring-beans.xsd")) {
          schema = new ClassPathResource("xsd/spring-beans.xsd");
        } else if (systemId.equals("http://www.springframework.org/schema/context/spring-context.xsd")) {
          schema = new ClassPathResource("xsd/spring-context.xsd");
        }

        if (null != schema) {
          inputSource = new InputSource(schema.getInputStream());
          inputSource.setSystemId(systemId);
        }
        return inputSource;
      }
    });


    Document document = documentBuilder.parse(resource.getInputStream());

    Element root = document.getDocumentElement();

    System.out.println(root.getNodeName());

    parse(root, 1);

  }

  public static void parse(Node node, int depth) {
    NodeList nodeList = node.getChildNodes();

    for (int i = 0; i < nodeList.getLength(); i++) {
      Node childNode = nodeList.item(i);

      if (childNode instanceof Element) {
        for (int j = 0; j < depth; j++) {
          System.out.print("--");
        }

        System.out.println(childNode.getNodeName());

        if (childNode.hasChildNodes()) {
          parse(childNode, ++depth);
          depth--;
        }
      }
    }
  }


}
