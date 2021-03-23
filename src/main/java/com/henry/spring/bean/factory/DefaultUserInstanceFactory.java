package com.henry.spring.bean.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author heyong
 * @date 2020/11/16 19:54
 */
public class DefaultUserInstanceFactory implements UserInstanceFactory, InitializingBean, DisposableBean {

    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct 方法初始化...");
    }

    public void initUser() {
        System.out.println("@Bean.init-method自定义 方法初始化...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("实现InitializingBean#afterPropertiesSet() 方法初始化...");
    }

    @PreDestroy
    public void distroy() {
        System.out.println("@PreDestroy 方法销毁...");
    }

    public void distroyUser() {
        System.out.println("@Bean.distroy-method自定义 方法销毁...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("实现DisposableBean#destroy() 方法销毁...");
    }


    @Override
    protected void finalize() throws Throwable {
        System.out.println("DefaultUserInstanceFactory 正在被回收...");
        super.finalize();
    }
}
