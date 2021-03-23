package com.henry.spring.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Bean 对象 GC
 * 垃圾回收会有一定几率触发 Object 的finalize() 方法
 * @anthor heyong
 */
public class BeanGarbageCollocationDemo {

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(BeanInitializationDemo.class);

        applicationContext.refresh();

        applicationContext.close();

        Thread.sleep(5000L);

        // 垃圾回收  垃圾回收会有一定几率触发 Object 的finalize() 方法
        System.gc();

        Thread.sleep(5000L);

    }
}
