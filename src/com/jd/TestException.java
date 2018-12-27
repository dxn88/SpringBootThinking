package com.jd;

import io.netty.util.internal.EmptyArrays;

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
            e.printStackTrace();
        }
    }

    public static void testException() {
            throw new MyException("参数异常");
    }
}


class MyException extends RuntimeException {
    public MyException(String message) {
        super(message, null, false, false);
    }

//    @Override
//    public synchronized Throwable fillInStackTrace() {
////        setStackTrace(EmptyArrays.EMPTY_STACK_TRACE);
//        return this;
//    }
}