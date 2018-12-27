package com.jd;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/12/27
 */
public class TestException {
    public static void main(String[] args) {
        try {
            testException();
        } catch (RuntimeException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
            System.out.println("e= " + e);
        }
    }

    public static void testException() {
            throw new RuntimeException("参数异常");
    }
}
