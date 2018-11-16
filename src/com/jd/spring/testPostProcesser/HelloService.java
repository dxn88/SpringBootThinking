package com.jd.spring.testPostProcesser;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/11/15
 */

@RoutingSwitch("hello.switch")
public interface HelloService{

    @RoutingSwitch("A")
    void sayHello();

    void sayHi(String hi);
}