package com.jd.spring.testPostProcesser;

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

        HelloController bean = applicationContext.getBean(HelloController.class);
        bean.sayHello();
        bean.sayHi("World");
        //DisposableBean 调用
        ((ClassPathXmlApplicationContext) applicationContext).close();
    }

    public TestEnvInit() {
        System.out.println("TestEnvInit.TestEnvInit：构造方法");
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("TestEnvInit.destroy：销毁");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("TestEnvInit.afterPropertiesSet：构造方法之后初始化");
    }
}
