package com.jd.netty;

import java.io.PrintStream;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/11/20
 */
public class TestFinally {
    public static void main(String[] args) {

        print();

    }

    private static int print() {
        try {

            return printA();
        } finally {
            printB();
        }
    }

    private static int printA() {
        System.out.println("TestFinally.printA");
        return 5;
    }

    private static int printB() {
        System.out.println("TestFinally.printB");
        return 2;
    }
}
