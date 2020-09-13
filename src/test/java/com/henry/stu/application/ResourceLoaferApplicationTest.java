package com.henry.stu.application;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;

import java.io.IOException;

public class ResourceLoaferApplicationTest {

  @Test
  public void MylTestOfApplication() throws IOException {

    DefaultResourceLoader resourceLoader = new DefaultResourceLoader();

    ClassPathResource classPathResource = (ClassPathResource)resourceLoader.getResource("classpath:com/henry");

    if (classPathResource.exists()) {
      System.out.println("config file is exist, url:" + classPathResource.getURL().toString());
    }else {
      System.out.println("config file is not exist");
    }

    if (classPathResource.isFile()) {
      System.out.println("config file is file system");
    }else {
      System.out.println("config file is not file system");
    }
  }
}
