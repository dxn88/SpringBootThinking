package com.jd;

import lombok.SneakyThrows;

import java.lang.reflect.Method;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/12/27
 */

public class TestException {
    public static void main(String[] args) {
        MyException myException = new MyException("");
        myException.printStackTraceDepth();
        printStack(myException);
    }

    public static void printStack(MyException myException) {
        myException.printStackTraceDepth();
    }

}


/**
 * 为单例模式只一次获取反射
 */
class MyException extends RuntimeException {
    private  Method fillInStackTrace;

    private  Method getStackTraceDepth;

    private Method getStackTraceElement;

    public MyException(String message) {
        super(message, null, false, false);
        init();
    }

    @SneakyThrows
    public void init() {
        fillInStackTrace = Throwable.class.getDeclaredMethod("fillInStackTrace", int.class);
        fillInStackTrace.setAccessible(true);

        getStackTraceDepth = Throwable.class.getDeclaredMethod("getStackTraceDepth");
        getStackTraceDepth.setAccessible(true);

        getStackTraceElement = Throwable.class.getDeclaredMethod("getStackTraceElement", int.class);
        getStackTraceElement.setAccessible(true);
    }

    @SneakyThrows
    public void printStackTraceDepth() {

        Object invokefillInStackTrace = fillInStackTrace.invoke(this,0);
        System.out.println("invoke = " + invokefillInStackTrace);

        int depth = (int)getStackTraceDepth.invoke(this);
        System.out.println("invoke = " + depth);

        StackTraceElement invoke1 = (StackTraceElement)getStackTraceElement.invoke(this, depth -2);
        System.out.println("invoke1.getClassName() = " + invoke1.getClassName());
        System.out.println("invoke1.getLineNumber() = " + invoke1.getLineNumber());
        System.out.println("invoke1.getFileName() = " + invoke1.getFileName());
        System.out.println("invoke1.getMethodName() = " + invoke1.getMethodName());

    }
}

