package com.jd.spring;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: daixunan
 * @Date: 2018/10/24
 */
public class TestEnvInit  implements BeanNameAware {

    private String beanName;

    public static void main(String[] args) {
        System.setProperty("a", "bean");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("${a}.xml");
        TestEnvInit myBean = (TestEnvInit) applicationContext.getBean("myObject");
        System.out.println("myBean = " + myBean);
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public String toString() {
        return "TestEnvInit{" +
                "beanName='" + beanName + '\'' +
                '}';
    }
}
