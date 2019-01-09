package com.jd.spiimpl;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.SPI;
import com.jd.spi.HelloService;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2019/1/7
 */
@SPI
public class SayHelloImpl implements HelloService {

    @Override
    public void sayHello(URL url) {
        System.out.println("this is first mySpi");
    }
}
