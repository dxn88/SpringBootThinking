package com.jd;

import org.springframework.util.ConcurrentReferenceHashMap;
import org.springframework.util.MultiValueMap;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;

/**
 * @Auther: daixunan
 * @Date: 2018/10/5
 * @Data 参考资料 https://www.cnblogs.com/huajiezh/p/5835618.html
 * @Data 参考资料 https://blog.csdn.net/zqz_zqz/article/details/79474314
 */

public class TestConcurrentReferenceHashMap {
    private static Map<ClassLoader, MultiValueMap<String, String>> cache = new ConcurrentReferenceHashMap<>();

    public static void main(String[] args) {

        System.out.println("cache = " + cache);
        // 一旦垃圾回收器满了，就会回收软引用
        SoftReference sr = new SoftReference(cache);
        // 结束强引用
        cache = null;
        System.gc();
        System.out.println("sr.get() = " + sr.get());

        ReferenceQueue
        // 弱引用也是用来描述非必需对象的，当JVM进行垃圾回收时，无论内存是否充足，都会回收被弱引用关联的对象
        // 这说明只要JVM进行垃圾回收，被弱引用关联的对象必定会被回收掉。不过要注意的是，
        // 这里所说的被弱引用关联的对象是指只有弱引用与之关联，如果存在强引用同时与之关联，
        // 则进行垃圾回收时也不会回收该对象（软引用也是如此）。

        WeakReference<TestConcurrentReferenceHashMap> wr =
                new WeakReference<TestConcurrentReferenceHashMap>(new TestConcurrentReferenceHashMap());

        System.gc();
        System.out.println("wr.get() = " + wr.get());

    }

}
