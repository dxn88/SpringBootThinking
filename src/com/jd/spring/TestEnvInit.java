package com.jd.spring;

import com.sun.xml.internal.ws.api.policy.SourceModel;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: daixunan
 * @Date: 2018/10/24
 */
public class TestEnvInit  implements BeanNameAware, InitializingBean, DisposableBean {

    private String beanName;

    public static void main(String[] args) {
        // 系统属性针对jvm  环境变量针对操作系统
        System.setProperty("a", "bean");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("${a}.xml");

        //DisposableBean 调用
        ((ClassPathXmlApplicationContext) applicationContext).close();
    }

    public TestEnvInit() {
        System.out.println("TestEnvInit.TestEnvInit");
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("TestEnvInit.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("TestEnvInit.afterPropertiesSet");
    }
}
