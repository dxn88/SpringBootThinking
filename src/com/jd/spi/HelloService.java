package com.jd.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2019/1/7
 */
@SPI("dubbo")
public interface HelloService {
    @Adaptive
    void sayHello(URL url);
}
