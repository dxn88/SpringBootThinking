package com.jd.spring.testPostProcesser;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/11/15
 */

public class HelloServiceImplV2 implements HelloService{

    @Override
    public void sayHello(){
        System.out.println("Hello from V2");
    }

    @Override
    public void sayHi(){
        System.out.println("Hi from V2");
    }
}
