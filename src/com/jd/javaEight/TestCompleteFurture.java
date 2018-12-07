package com.jd.javaEight;

import java.util.Date;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/12/6
 */
public class TestCompleteFurture {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        CompletableFuture.supplyAsync(TestCompleteFurture::print)
//                .whenComplete((aDouble, throwable) -> {
//                    Optional.ofNullable(aDouble).ifPresent(System.out::println);
//                    Optional.ofNullable(throwable).ifPresent(System.out::println);
//                });

        CompletableFuture.supplyAsync(TestCompleteFurture::print).runAfterEither(CompletableFuture.supplyAsync(() -> {
            System.out.println("aaa");
            return 0.124;
        }), () -> {
            System.out.println("结束了，更改数据库 ");
        });

        new Date();

        Thread.currentThread().join();
    }

    public static Double print() {
        System.out.println("TestCompleteFurture.print");
        return 0.369;
    }
}
