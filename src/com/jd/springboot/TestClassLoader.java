package com.jd.springboot;

import com.sun.istack.internal.Nullable;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @Auther: daixunan
 * @Date: 2018/10/5
 * @Data 参考资料 https://www.cnblogs.com/hypnotizer/p/5522020.html    类加载机制
 * @Data 参考资料 https://www.jianshu.com/p/b6547abd0706    类加载机制
 * @Data 参考资料 https://blog.csdn.net/zhoudaxia/article/details/35897057    类加载机制
 */

// 利用forName加载可以从配置文件读取属性，转成String 这是喝class不同的方式
public class TestClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, NoSuchMethodException, InvocationTargetException {

//        ClassLoader clToUse = getDefaultClassLoader();
//        String name = OuterClass.innerClassPath;
//        Class<?> clazz = null;
//        try {
//            clazz = (clToUse != null ? clToUse.loadClass(name) : Class.forName(name));
//            System.out.println("clazz = " + clazz);
//        }
//        catch (ClassNotFoundException ex) {
//                String innerClassName =
//                        OuterClass.convert2InnerClassPath(name);
//                try {
//                    // jvm 加载分三步 加载，链接，初始化 classloader只负责第一步  forname负责三步，调用static方法
//                    clazz = (clToUse != null ? clToUse.loadClass(innerClassName) : Class.forName(innerClassName));
//                }
//                catch (ClassNotFoundException ex2) {
//                    // Swallow - let original exception get through
//                }
//            }
//            System.out.println("clazz = " + clazz);
        TestUrlLoader();

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

    private static void TestUrlLoader() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        URL url = new URL("file:/");
        URLClassLoader loader = new URLClassLoader(new URL[]{url}, null);
        Class cl = Class.forName ("com.jd.springboot.UseUrlClassLoader", true, loader);
        Object foo = (UseUrlClassLoader)cl.newInstance();
        Method print = cl.getMethod("print");
        print.invoke(foo);
        System.out.println(foo instanceof UseUrlClassLoader);

        Class clazz = Class.forName ("com.jd.springboot.UseUrlClassLoader");
        Object o = clazz.newInstance();
        System.out.println(o instanceof UseUrlClassLoader);

    }

    private void print() {
        System.out.println("hello Urlloader!");
    }

}
