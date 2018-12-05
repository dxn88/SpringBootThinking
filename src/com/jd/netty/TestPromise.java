package com.jd.netty;

import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/12/2
 */
public class TestPromise {

    @Test
    public void testListenerNotifyLater() {
        int numListenersBefore = 2; // 设置结果前设置两个listener
        int numListenersAfter = 3; // 设置结果后设置三个listener

        CountDownLatch latch = new CountDownLatch(numListenersBefore + numListenersAfter);
        DefaultPromise<Void> promise = new DefaultPromise<>(GlobalEventExecutor.INSTANCE);

        for (int i = 0; i < numListenersBefore; i++) {
            promise.addListener(new FutureListener<Void>() {
                @Override
                public void operationComplete(Future<Void> future) throws Exception {
                    latch.countDown();
                }
            });
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                promise.setSuccess(null);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < numListenersAfter; i++) {
                            promise.addListener(future -> {
                                latch.countDown();
                            });
                        }
                    }
                }).start();
            }
        }).start();

        try {
            latch.await(100, TimeUnit.SECONDS);
            System.out.println("promise = " + promise);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
