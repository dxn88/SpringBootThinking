package com.jd;

/**
 * @Auther: daixunan
 * @Date: 2018/10/5
 */
public class TestMainClass {
    public static void main(String[] args) {

        System.out.println(deduceMainApplicationClass().getName());
    }

   static private Class<?> deduceMainApplicationClass() {
        try {
            StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                if ("main".equals(stackTraceElement.getMethodName())) {
                    return Class.forName(stackTraceElement.getClassName());
                }
            }
        }
        catch (ClassNotFoundException ex) {
            // Swallow and continue
        }
        return null;
    }
}
