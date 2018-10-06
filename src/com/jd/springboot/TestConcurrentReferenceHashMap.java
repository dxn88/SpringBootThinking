package com.jd.springboot;

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
 * @Data 参考资料 https://blog.csdn.net/qq_33804730/article/details/79451670
 * @Data 参考资料 https://www.cnblogs.com/huajiezh/p/5835618.html
 */

// 这将导致this逸出，所谓逸出，就是在不该发布的时候发布了一个引用。
// 在这个例子里面，当我们实例化ThisEscape对象时，会调用source的registerListener方法，
// 这时便启动了一个线程，而且这个线程持有了ThisEscape对象（调用了对象的doSomething方法），
// 但此时ThisEscape对象却没有实例化完成（还没有返回一个引用），所以我们说，此时造成了一个this引用逸出，
// 即还没有完成的实例化ThisEscape对象的动作，却已经暴露了对象的引用。其他线程访问还没有构造好的对象，可能会造成意料不到的问题。
//    解决办法是先构造好方法在进行线程初始化

public class TestConcurrentReferenceHashMap {
    // map的引用被回收了，但是key还在map中，此时清理 ReferenceQueue
    private static Map<ClassLoader, MultiValueMap<String, String>> cache = new ConcurrentReferenceHashMap<>();

    public static void main(String[] args) {

        System.out.println("cache = " + cache);
        // 一旦垃圾回收器满了，就会回收软引用
        SoftReference sr = new SoftReference(cache);
        // 结束强引用
        cache = null;
        System.gc();
        System.out.println("sr.get() = " + sr.get());

        // 弱引用也是用来描述非必需对象的，当JVM进行垃圾回收时，无论内存是否充足，都会回收被弱引用关联的对象
        // 这说明只要JVM进行垃圾回收，被弱引用关联的对象必定会被回收掉。不过要注意的是，
        // 这里所说的被弱引用关联的对象是指只有弱引用与之关联，如果存在强引用同时与之关联，
        // 则进行垃圾回收时也不会回收该对象（软引用也是如此）。

        WeakReference<TestConcurrentReferenceHashMap> wr =
                new WeakReference<TestConcurrentReferenceHashMap>(new TestConcurrentReferenceHashMap());

        System.gc();
        System.out.println("wr.get() = " + wr.get());

    // ReferenceQueue队列的作用就是Reference引用的对象被回收时，Reference对象能否进入到pending队列，
    // 最终由ReferenceHander线程处理后，Reference就被放到了这个队列里面（Cleaner对象除外，后面有一篇专门讲Cleaner对象源码）
    // ，然后我们就可以在这个ReferenceQueue里拿到reference,执行我们自己的操作（至于什么操作就看你想怎么用了），
    // 所以这个队列起到一个对象被回收时通知的作用；
        ReferenceQueue rq = new ReferenceQueue();

// 不像软引用、弱引用会自动回收内存，虚引用的存在（虽然内存还是会被回收）更倾向于发送通知，
// 当一个对象确定会被回收之后（此时虚引用中的引用对象并不能确定是否已经被回收内存了，而软引用和弱引用一定是被回收内存了的），
// 就会向应用程序发送一个通知（进入队列和出队列），“我要被清理了，你们是否要做些什么事情呢？”。
// 所以，虚引用用来做对象清理工作，比finalize方法再好不过了，不会导致垃圾回收器额外做工作，
// 配合Reference阻塞方法remove就能更及时做清理工作。

    }

}
