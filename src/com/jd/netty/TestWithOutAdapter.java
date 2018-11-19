package com.jd.netty;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/11/19
 */
public class TestWithOutAdapter implements caculate{
}

// 接口默认实现，省去了Adapter类的默认实现 java8新增功能
interface caculate{
    default int add(){ return 0;}
    default int deduce(){ return 0;}
    default int mul(){ return 0;}
}

// 下面的不要了
abstract class TestAdapter implements caculate{
    @Override
    public int add() {
        return 0;
    }

    @Override
    public int deduce() {
        return 0;
    }

    @Override
    public int mul() {
        return 0;
    }
}
