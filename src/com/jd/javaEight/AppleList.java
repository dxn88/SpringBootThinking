package com.jd.javaEight;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/12/5
 */
public class AppleList {

    @FunctionalInterface
    public interface ApplFilter{
        boolean filter(Apple apple);
    }

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();

        Apple apple = new Apple();
        apple.setColor("green");
        apple.setWeight(100);
        Apple apple1 = new Apple();
        apple1.setColor("red");
        apple1.setWeight(100);
        apples.add(apple);
        apples.add(apple1);

        List<Apple> greenApples = findApple(apples, new GreenAppleAndWeiht100Fileter());
        System.out.println("greenApples = " + greenApples);

        // 用lamba表达式方式
        List<Apple> redApples = findApple(apples, (appleValue) -> {
            if ("red".equals(appleValue.getColor())) {
                return true;
            }
            return false;
        });
        System.out.println("redApples = " + redApples);

    }

    public static class GreenAppleAndWeiht100Fileter implements ApplFilter {
        private static final String GREEN_COLOR = "green";
        private static final int WEIGHT = 100;

        @Override
        public boolean filter(Apple apple) {
            if (GREEN_COLOR.equals(apple.getColor()) && WEIGHT == apple.getWeight()) {
                return true;
            }
            return false;
        }
    }
    public static List<Apple> findApple(List<Apple> apples, ApplFilter applFilter) {

        List<Apple> greenApples = new ArrayList<>();

        apples.forEach( apple -> {
            if (applFilter.filter(apple)) {
                greenApples.add(apple);
            }

        });

        return greenApples;
    }
}
