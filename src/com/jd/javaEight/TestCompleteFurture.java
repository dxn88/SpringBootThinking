package com.jd.javaEight;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/12/6
 */
public class TestCompleteFurture {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.supplyAsync(TestCompleteFurture::print)
                .whenComplete((aDouble, throwable) -> {
                    Optional.ofNullable(aDouble).ifPresent(System.out::println);
                    Optional.ofNullable(throwable).ifPresent(System.out::println);
                });

        Thread.currentThread().join();

    }

    public static Double print() {
        return 0.369;
    }
}
