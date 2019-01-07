package com.jd.juc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2019/1/7
 */
public class TestJUCCollection {

    public static void main(String[] args) {
        List<String> s = new ArrayList<>();
        List<String> strings = Collections.synchronizedList(s);

        /**
         * 写的时候枷锁，拷贝一份出来增加，不影响读，增加之后再把引用替换
         */
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add(new Integer(3));

    }
}
