package com.jd.javaEight;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/12/5
 */
public class TestStream {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();

        Apple apple = new Apple();
        apple.setColor("green");
        apple.setWeight(103);
        Apple apple1 = new Apple();
        apple1.setColor("red");
        apple1.setWeight(100);

        Apple apple2 = new Apple();
        apple2.setColor("red");
        apple2.setWeight(102);
        apples.add(apple);
        apples.add(apple1);
        apples.add(apple2);


        // parallstream并行处理
        Stream<Apple> sorted = apples.stream().filter(applef -> applef.getWeight() > 99).sorted(Comparator.comparing(Apple::getWeight));
        List<String> collect = sorted.map(Apple::getColor).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }
}
