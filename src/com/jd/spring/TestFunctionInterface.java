package com.jd.spring;

/**
 * @Auther: daixunan
 * @Date: 2018/10/22
 */

/**
 * 参考资料 https://www.cnblogs.com/runningTurtle/p/7092632.html
 */
public class TestFunctionInterface {

    public static void main(String[] args) {
        GreetingService greetService = message -> System.out.println("Hello " + message);

        greetService.sayMessage("world");
    }

    @FunctionalInterface
    interface GreetingService
    {
        void sayMessage(String message);

        default void print(){
            // 可以有默认实现  只要有切只有一个抽象方法就可以啦
        }
    }
}
