package com.jd.jvm;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/12/25
 */
public class TestString {
    // a和b都在常量池中，所以相等
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();

        String a = "123";
        String b = "123";
        for (int i = 0; i < 1000000; i++) {
            if (a.equals(b)) {
            }
        }

        long end = System.currentTimeMillis() - begin;

        System.out.println("end = " + end);


    }

    public void test1() {
        String a = "123";
        String b = "123";
        String c = new String("123");
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a == c.intern());
    }
}
