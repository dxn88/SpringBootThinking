package com.jd.javaEight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/12/6
 */
public class TestDateTime {
    public static void main(String[] args) {
        System.out.println("new Date() = " + new Date());
        System.out.println("LocalDateTime.now() = " + LocalDateTime.now());
        System.out.println("LocalDate.now() = " + LocalDate.now());
        System.out.println("LocalTime = " + LocalTime.now());
        System.out.println("LocalDateTime.of() = " + LocalDateTime.of(LocalDate.now(), LocalTime.now()));

    }
}
