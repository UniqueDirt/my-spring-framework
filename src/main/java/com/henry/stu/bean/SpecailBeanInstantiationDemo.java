package com.henry.stu.bean;

import com.henry.stu.bean.factory.DefaultUserInstanceFactory;
import com.henry.stu.bean.factory.UserInstanceFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 非正常方式实例化 Bean
 */
public class SpecailBeanInstantiationDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:bean-special-config.xml");

        // 通過application context獲取 AutowireCapableBeanFactory
        AutowireCapableBeanFactory beanFactroy = applicationContext.getAutowireCapableBeanFactory();

        ServiceLoader<UserInstanceFactory> serviceLoader = beanFactroy.getBean("userFactoryServiceLoader", ServiceLoader.class);

        demoServiceLoader();

        displayServiceLoader(serviceLoader);

        // 通過 AutowireCapableBeanFactory 註冊 Bean
        UserInstanceFactory userInstanceFactory = beanFactroy.createBean(DefaultUserInstanceFactory.class);

        System.out.println("通过AutowireCapableBeanFactory创建Bean" + userInstanceFactory.getUser());
    }

    public static void demoServiceLoader() {
        ServiceLoader<UserInstanceFactory> serviceLoader = ServiceLoader.load(UserInstanceFactory.class, Thread.currentThread().getContextClassLoader());
        displayServiceLoader(serviceLoader);
    }

    private static void displayServiceLoader(ServiceLoader serviceLoader) {
        Iterator<UserInstanceFactory> iterable = serviceLoader.iterator();
        while (iterable.hasNext()) {
            UserInstanceFactory userFactory = iterable.next();
            System.out.println(userFactory.getUser());
        }
    }
}
