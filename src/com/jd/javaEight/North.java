package com.jd.javaEight;

import jdk.management.resource.ResourceId;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/12/5
 */
@Data
public class North {
    private volatile String name = "nanfang";
    private static int i = 5;

    public static void main(String[] args) {
        ResourceId resourceId = () -> "hello";
        ResourceId rd = North::getId;

        List<String> list = new ArrayList<>(8);
        list.add("hello");
        System.out.println("list.contains(\"hello\") = " + list.contains("hello"));

        BiFunction<String, Integer, Character> sca = String::charAt;
        System.out.println("sca = " + sca.apply("abce", 2));
    }

    public static String getId() {
        return "getIdo";
    }
}
