package com.jd.spring;

import org.springframework.aop.framework.ProxyFactory;

import java.io.Serializable;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/10/26
 */

// 参考资料 https://www.jianshu.com/p/1f8dbeadd79d
// 参考资料 https://www.jianshu.com/u/eccd5acf909e    ****
public class TestAOP {

    public static void main(String[] args) {
//        ProxyFactory proxyFactory =new ProxyFactory();
//        proxyFactory.setInterfaces(HelloService.class);
//        proxyFactory.setTarget(new HelloServiceImpl());
//        proxyFactory.addAdvice(new TestBeforeAdvice());
//        proxyFactory.addAdvice(new TestAfterAdvice());
//        proxyFactory.addAdvice(new TestAroundAdvice());
//        proxyFactory.setExposeProxy(true);
//        HelloService helloService = (HelloService) proxyFactory.getProxy();
//        HelloService helloService1 = (HelloService) proxyFactory.getProxy();
//        int add = helloService.add(2, 4);
//        int add1 = helloService1.add(2, 4);
//        System.out.println("add = " + add);
//        System.out.println("add1 = " + add1);
    }

}

//proxyTargetClass，true代表直接代理类，false代表代理接口。默认为false
//        optimize，是否执行某些优化，感觉基本没怎么用到
//        opaque，代表子类是否能被转换为Advised接口，默认为false，表示可以
//        exposeProxy，是否暴露代理，也就是是否把当前代理对象绑定到AopContext的ThreadLocal属性currentProxy上去，常用于代理类里面的代理方法需要调用同类里面另外一个代理方法的场景。
//        frozen，当前代理配置是否被冻结，如果被冻结，配置将不能被修改

