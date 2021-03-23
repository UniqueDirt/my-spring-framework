package com.henry.spring.bean;

import com.henry.spring.bean.factory.DefaultUserInstanceFactory;
import com.henry.spring.bean.factory.UserInstanceFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * @description Bean 初始化、 延迟加载 Bean 与非延迟加载 Bean 的区别
 * Bean 初始化的三种方式 （按执行顺序） 1、@PostConstruct 2、实现InitializingBean#afterPropertiesSet  3、@Bean(init-method) / xml配置
 * Bean 销毁的三种方式  （按执行顺序） 1、@PreDestroy 2、实现DisposableBean#destroy()  3、@Bean(destroy-method) / xml配置
 * 延迟加载方式 1、@Lazy  2、xml 配置 init-lazy   延迟加载的bean是在application context上下文加载完成之后且有被使用时才会加载  一非延迟加载则在容器加载完成前初始化
 * 延迟加载只影响 Bean 的初始化顺序   不影响 Bean 的销毁顺序
 *
 * environment 指的是什么
 * @anthor heyong
 * @date
 */
public class BeanInitializationDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

//        applicationContext.register(BeanInitializationDemo.class, DefaultUserInstanceFactory.class);

        applicationContext.register(BeanInitializationDemo.class);

        applicationContext.refresh();

        System.out.println("application context 上下文加载完成！");

        applicationContext.getBean(UserInstanceFactory.class);

        System.out.println("application context 准备关闭中...");

        applicationContext.close();

        System.out.println("application context 上下文关闭！");

    }

    @Lazy(value = false)
    public UserInstanceFactory initUserFactory() {
        return new DefaultUserInstanceFactory();
    }
}
