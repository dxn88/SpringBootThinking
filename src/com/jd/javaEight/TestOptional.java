package com.jd.javaEight;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/12/5
 */
public class TestOptional {
    public static void main(String[] args) {

        Optional<Apple> apple = Optional.ofNullable(null);
//        Optional.ofNullable(null).orElseThrow(RuntimeException::new);
        System.out.println("apple.get() = " + apple.orElseGet(Apple::new));
        String appleColor = getAppleColor(new Apple());
        String appleColor1 = getAppleColor(null);
        System.out.println("appleColor = " + appleColor);
        Optional.ofNullable(getAppleProductPlace(null)).ifPresent(System.out::println);
        Optional.ofNullable(getAppleProductPlace(new Apple())).ifPresent(System.out::println);
    }

    public static String getAppleColor(Apple apple) {
        return Optional.ofNullable(apple).map(Apple::getColor).orElse("unknown");
    }

    // 真好用，棒棒哒！
    public static String getAppleProductPlace(Apple apple) {
        return Optional.ofNullable(apple).map(Apple::getProductPlace).map(ProductPlace::getNorth)
                .map(North::getName).orElse("unknown");
    }

}
