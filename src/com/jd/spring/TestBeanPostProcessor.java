package com.jd.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/11/15
 */

public class TestBeanPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean = " + bean);
        System.out.println("beanName = " + beanName);
        System.out.println("TestBeanPostProcessor.postProcessBeforeInitialization");
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean = " + bean);
        System.out.println("beanName = " + beanName);
        System.out.println("TestBeanPostProcessor.postProcessAfterInitialization");
        return null;
    }
}
