package com.henry.stu.bean;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.genericBeanDefinition;

/**
 * 通过注解定义 Bean 的几种方式
 * 1、@Bean 注解定义 Bean
 * 2、@Component 注解定义 Bean
 * 3、Import 注解定义Bean
 */
@Import(AnnotationDefinitionBean.MyBeanConfig.class)  // 第二种方式定义 Bean
public class AnnotationDefinitionBean {


    public static void main(String[] args) {
        // 定义 AnnotationApplication 上下文
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册上下文
        applicationContext.register(AnnotationDefinitionBean.class);

        // 通过 BeanDefinition 注册API实现
        // 命名 Bean 的注册方式实现
        registerBeanDefinition(applicationContext, "mer-persion", Person.class);

        // 非命名方式注册
        registerBeanDefinition(applicationContext, Person.class);

        // 重启/刷新容器
        applicationContext.refresh();

        // 获取 config Bean 对象
        System.out.println("BeanConfigMap: " + applicationContext.getBeansOfType(MyBeanConfig.class));
        // 获取 Person Bean 对象
        System.out.printf("PersonMap：" + applicationContext.getBeansOfType(Person.class));

        // 关闭/销毁容器
        applicationContext.close();

    }


    /**
     * 命名 Bean 的注册方式
     * @param registry
     * @param benaName
     * @param beanClass
     */
    public static void registerBeanDefinition(BeanDefinitionRegistry registry, String benaName, Class<?> beanClass) {
        BeanDefinitionBuilder beanDefinitionBuilder = genericBeanDefinition(beanClass);
        beanDefinitionBuilder.addPropertyValue("id", 1);
        beanDefinitionBuilder.addPropertyValue("name", "hyy");

        // 判断如果 beanName 参数存在时
        if (StringUtils.hasText(benaName)) {
            // 注册 BeanDefinition
            registry.registerBeanDefinition(benaName, beanDefinitionBuilder.getBeanDefinition());
        }else {
            // 非命名方式注册
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), registry);
        }

    }

    public static void registerBeanDefinition(BeanDefinitionRegistry registry, Class<?> beanClass) {
        registerBeanDefinition(registry, null, beanClass);
    }


    @Component
    public static class MyBeanConfig {

        @Bean(name = {"person", "person-bean"})     // 第一种方式
        public Person PersonByBeanAnnotation() {
            Person person = new Person();
            person.setId(1);
            person.setName("hy");
            return person;
        }

    }

    // 定义 Person 实体类
    public static class Person {

        private Integer id;

        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }


}
