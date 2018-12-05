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
    }
}
