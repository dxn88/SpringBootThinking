package com.jd.spiimpl;

import com.jd.spi.HelloService;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2019/1/7
 */
public class SayHelloImpl implements HelloService {

    @Override
    public void sayHello() {
        System.out.println("this is first mySpi");
    }
}
