package com.jd.spring;

import java.io.Serializable;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/10/26
 */

// 参考资料 https://www.jianshu.com/p/1f8dbeadd79d
// 参考资料 https://www.jianshu.com/u/eccd5acf909e    ****
public class TestAOP {
}

//proxyTargetClass，true代表直接代理类，false代表代理接口。默认为false
//        optimize，是否执行某些优化，感觉基本没怎么用到
//        opaque，代表子类是否能被转换为Advised接口，默认为false，表示可以
//        exposeProxy，是否暴露代理，也就是是否把当前代理对象绑定到AopContext的ThreadLocal属性currentProxy上去，常用于代理类里面的代理方法需要调用同类里面另外一个代理方法的场景。
//        frozen，当前代理配置是否被冻结，如果被冻结，配置将不能被修改


class ProxyConfig implements Serializable {

    /**
     * use serialVersionUID from Spring 1.2 for interoperability
     */
    private static final long serialVersionUID = -8409359707199703185L;

    private boolean proxyTargetClass = false;

    private boolean optimize = false;

    boolean opaque = false;

    boolean exposeProxy = false;

    private boolean frozen = false;


}