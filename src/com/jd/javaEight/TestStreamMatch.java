package com.jd.javaEight;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/12/5
 */
public class TestStreamMatch {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 3, 4, 5, 6, 7, 6, 5, 7, 8, 9, 1);

        boolean b = integerStream.allMatch(i -> i > 1);
        System.out.println("b = " + b);

        integerStream = Stream.of(1, 2, 3, 3, 4, 5, 6, 7, 6, 5, 7, 8, 9, 1);
        boolean b1 = integerStream.anyMatch(i -> i < 0);
        System.out.println("b1 = " + b1);

        integerStream = Stream.of(1, 2, 3, 3, 4, 5, 6, 7, 6, 5, 7, 8, 9, 1);
        Optional<Integer> any = integerStream.filter(i -> i > 5).findAny();

        integerStream = Stream.of(1, 2, 3, 3, 4, 5, 6, 7, 6, 5, 7, 8, 9, 1);
        Optional<Integer> first = integerStream.filter(i -> i > 5).findFirst();

        first.ifPresent(System.out::println);
    }
}
