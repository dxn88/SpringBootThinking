package com.jd;

import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2019/1/3
 */
public class TestCallerClass {
    @CallerSensitive
    public static void main(String[] args) throws ClassNotFoundException {
        TestReflection.test();
    }

    public static void time() {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            Class<?> caller = Reflection.getCallerClass(1);

        }
        long end = System.currentTimeMillis() - begin;

        System.out.println("time = " + end);
    }
}

class TestReflection {
    @CallerSensitive
    public static void test() {
        Class<?> callerClass = Reflection.getCallerClass();
        System.out.println("callerClass = " + callerClass);
    }
}