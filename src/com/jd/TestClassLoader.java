package com.jd;

import com.sun.istack.internal.Nullable;

/**
 * @Auther: daixunan
 * @Date: 2018/10/5
 */
public class TestClassLoader {

    public static void main(String[] args) {

        ClassLoader clToUse = getDefaultClassLoader();
        String name = OuterClass.innerClassPath;
        Class<?> clazz = null;
        try {
            clazz = (clToUse != null ? clToUse.loadClass(name) : Class.forName(name));
            System.out.println("clazz = " + clazz);
        }
        catch (ClassNotFoundException ex) {
                String innerClassName =
                        OuterClass.convert2InnerClassPath(name);
                try {
                    // jvm 加载分三步 加载，链接，初始化 classloader只负责第一步  forname负责三步，调用static方法
                    clazz = (clToUse != null ? clToUse.loadClass(innerClassName) : Class.forName(innerClassName));
                }
                catch (ClassNotFoundException ex2) {
                    // Swallow - let original exception get through
                }
            }
            System.out.println("clazz = " + clazz);
        }

        // classloader 获取
    @Nullable
    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        }
        catch (Throwable ex) {
            // Cannot access thread context ClassLoader - falling back...
        }
        if (cl == null) {
            // No thread context class loader -> use class loader of this class.
            cl = TestClassLoader.class.getClassLoader();
            if (cl == null) {
                // getClassLoader() returning null indicates the bootstrap ClassLoader
                try {
                    cl = ClassLoader.getSystemClassLoader();
                }
                catch (Throwable ex) {
                    // Cannot access system ClassLoader - oh well, maybe the caller can live with null...
                }
            }
        }
        return cl;
    }


    // 覆盖线程classloader
    @Nullable
    public static ClassLoader overrideThreadContextClassLoader(@Nullable ClassLoader classLoaderToUse) {
        Thread currentThread = Thread.currentThread();
        ClassLoader threadContextClassLoader = currentThread.getContextClassLoader();
        if (classLoaderToUse != null && !classLoaderToUse.equals(threadContextClassLoader)) {
            currentThread.setContextClassLoader(classLoaderToUse);
            return threadContextClassLoader;
        }
        else {
            return null;
        }
    }
}
