package com.jd.juc;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/12/10
 */
// https://blog.csdn.net/zhuyong7/article/details/80852884
    // interrupted()

/**
 * 线程退出也会把状态为置为false
 */
public class TestBaseThread {
    public static void main(String[] args) throws InterruptedException {
        Demo demo = new Demo();
        demo.start();

        System.out.println("isInterrupted.before: " + demo.isInterrupted());
        demo.interrupt();
        System.out.println("isInterrupted.after1: " + demo.isInterrupted());
        Thread.sleep(1000);
        System.out.println("isInterrupted.after2: " + demo.isInterrupted());
    }
}

class Demo extends Thread {
    @Override
    public void run() {
        while (!isInterrupted()) {
//            try {
//                System.out.println("getName() = " + getName());
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
                System.out.println("Thread.currentThread().isInterrupted: " + Thread.currentThread().isInterrupted());
////                System.out.println(Thread.interrupted());
////                System.out.println("interrupted: " + interrupted());
//            }
        }
        while (true) {

        }
    }
}
