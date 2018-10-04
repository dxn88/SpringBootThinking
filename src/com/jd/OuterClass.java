package com.jd;

/**
 * @Auther: daixunan
 * @Date: 2018/10/5
 */
public class OuterClass {
    public static void main(String[] args) {
        // 外部类和内部类用$符号链接
        System.out.println("InnerClass.class.getName() = " + InnerClass.class.getName());
    }

    public static class InnerClass{}
}
