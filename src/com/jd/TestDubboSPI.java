package com.jd;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.jd.spi.HelloService;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2019/1/9
 */
public class TestDubboSPI {

    private static HelloService helloService =  ExtensionLoader.getExtensionLoader(HelloService.class).getExtension("dubbo");
    public static void main(String[] args) {
        URL url = new URL(null, "", 0);
        helloService.sayHello(null);
    }
}
