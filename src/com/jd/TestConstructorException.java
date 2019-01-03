package com.jd;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2019/1/3
 */

public class TestConstructorException {
    public static void main(String[] args) {

        new Test();
    }
}

/**
 * 我们不要在构造方法里面抛异常，而是在工厂方法提前检查参数
 */
class Test{
    public Test() {
        throw new RuntimeException("Constructor Exception!");
    }
}
