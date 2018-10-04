package com.jd;

import com.sun.deploy.util.StringUtils;

/**
 * @Auther: daixunan
 * @Date: 2018/10/5
 */
public class OuterClass {

    public static final char PACKAGE_SEPARATOR = '.';
    public static final char INNER_CLASS_SEPARATOR = '$';

    public static final String innerClassPath = "com.jd.OuterClass.InnerClass";

    public static void main(String[] args) {
        // 外部类和内部类用$符号链接
        System.out.println("InnerClass.class.getName() = " + InnerClass.class.getName());

        String innerClass = convert2InnerClassPath(innerClassPath);

        System.out.println("innerClass = " + innerClass);
    }

    public static String convert2InnerClassPath(String path) {
        int lastDotIndex = path.lastIndexOf(PACKAGE_SEPARATOR);
        if (lastDotIndex != -1) {
            String innerClassName = path.substring(0, lastDotIndex) + INNER_CLASS_SEPARATOR + path.substring(lastDotIndex + 1);
            return innerClassName;
        }

        return "";
    }

    public static class InnerClass{}


}
