package com.jd.juc;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/11/16
 */
public class TestAtomic {

    private static AtomicInteger num = new AtomicInteger(0);
    private static AtomicStampedReference<Integer> atomicStampedRef =
            new AtomicStampedReference<Integer>(100, 0);

    public static void main(String[] args) {

        int i = num.addAndGet(100);
        System.out.println("i = " + i);
        int stamp = atomicStampedRef.getStamp();
        System.out.println("stamp = " + stamp);
        System.out.println("atomicStampedRef.getReference() = " + atomicStampedRef.getReference());
        boolean b = atomicStampedRef.compareAndSet(atomicStampedRef.getReference(), 101, atomicStampedRef.getStamp(), atomicStampedRef.getStamp() + 1);
        System.out.println("b = " + b);
        System.out.println("atomicStampedRef.getReference() = " + atomicStampedRef.getReference());

        boolean b1 = atomicStampedRef.compareAndSet(atomicStampedRef.getReference(), 100, stamp, stamp + 1);
        System.out.println("b1 = " + b1);
        System.out.println("atomicStampedRef.getReference() = " + atomicStampedRef.getReference());

    }
}
