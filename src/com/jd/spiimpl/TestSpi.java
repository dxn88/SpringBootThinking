package com.jd.spiimpl;

import com.jd.spi.HelloService;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2019/1/7
 */
public class TestSpi {
    public static void main(String[] args) {
        ServiceLoader<HelloService> s = ServiceLoader.load(HelloService.class);
        Iterator<HelloService> searchs = s.iterator();
        if(searchs.hasNext()){
            HelloService speak = searchs.next();
            speak.sayHello();
        }

    }
}
