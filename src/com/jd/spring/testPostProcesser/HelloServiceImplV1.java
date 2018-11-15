package com.jd.spring.testPostProcesser;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/11/15
 */

public class HelloServiceImplV1 implements HelloService{

    @Override
    public void sayHello(){
        System.out.println("Hello from V1");
    }

    @Override
    public void sayHi(){
        System.out.println("Hi from V1");
    }
}
