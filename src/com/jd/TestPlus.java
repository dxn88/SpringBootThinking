package com.jd;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2019/1/3
 * ++i和i++效率几乎相同
 */
public class TestPlus {
    public static void main(String[] args) {
        testb();
    }

    public static void testa() {
        long begin = System.currentTimeMillis();
        int a =0;
        for (int i = 0; i < 100000000; i++) {
            ++a;
        }
        long end = System.currentTimeMillis() - begin;
        System.out.println("end = " + end);
    }

    public static void testb() {
        long begin = System.currentTimeMillis();
        int b =0;
        for (int i = 0; i < 100000000; i++) {
            b++;
        }
        long end = System.currentTimeMillis() - begin;
        System.out.println("end = " + end);
    }
}
