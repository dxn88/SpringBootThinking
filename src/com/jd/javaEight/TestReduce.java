package com.jd.javaEight;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/12/5
 */
public class TestReduce {
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

        Integer reduce = apples.stream().map(Apple::getWeight).reduce(0, (v1, v2) -> v1 + v2);
        System.out.println("reduce = " + reduce);
    }
}
