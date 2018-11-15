package com.jd.spring.testPostProcesser;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/11/15
 */
public class HelloController{

    @RoutingInjected
    private HelloService helloService;

    public void sayHello(){
        this.helloService.sayHello();
    }

    public void sayHi(){
        this.helloService.sayHi();
    }

}
