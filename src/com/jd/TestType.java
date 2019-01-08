package com.jd;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2019/1/8
 */
public class TestType {
    public static void main(String[] args) {
        Class<TestType> testTypeClass = TestType.class;

        System.out.println("testTypeClass = " + testTypeClass);
    }
}

/**
 * 只要有个子类灭有写  @Override 父类就会报错
 */
interface Hello{
    /**
     * hello
     */
    void hello();
}

class HelloImpl implements Hello {
    @Override
    public void hello() {

    }
}

class HelloImpl2 implements Hello {
    public void hello() {

    }
}