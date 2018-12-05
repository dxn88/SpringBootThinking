package com.jd.javaEight;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/12/5
 */
public class TestCollectors {

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

        Optional.ofNullable(getListApplesBycolor(apples)).ifPresent(System.out::println);
    }

    // list 转map 很方便
    public static Map<String, List<Apple>> getListApplesBycolor(List<Apple> apples) {
        return apples.stream().collect(Collectors.groupingBy(Apple::getColor));
    }
}
