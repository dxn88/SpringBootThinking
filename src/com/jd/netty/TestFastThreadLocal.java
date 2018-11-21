package com.jd.netty;

import io.netty.util.concurrent.FastThreadLocal;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/11/21
 */
public class TestFastThreadLocal {

    public static void main(String[] args) {
        FastThreadLocal<Integer> local = new FastThreadLocal<>();
        System.out.println("local = " + local.get());
        local.set(66);
        System.out.println("local.get() = " + local.get());
        local.remove();
        System.out.println("local. = " + local.get());
    }
}
