package com.jd.javaEight;

import java.util.Optional;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/12/5
 */
public class TestOptional {
    public static void main(String[] args) {

        Optional<Apple> apple = Optional.ofNullable(null);
        System.out.println("apple.get() = " + apple.orElseGet(Apple::new));
        String appleColor = getAppleColor(new Apple());
        String appleColor1 = getAppleColor(null);
        System.out.println("appleColor = " + appleColor);
        String appleProductPlace = getAppleProductPlace(null);
        System.out.println("appleProductPlace = " + appleProductPlace);
        String appleProductPlace1 = getAppleProductPlace(new Apple());
        System.out.println("appleProductPlace1 = " + appleProductPlace1);
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
