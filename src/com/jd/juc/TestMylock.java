package com.jd.juc;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2019/1/3
 */
public class TestMylock {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (true){
                    try {
                        System.out.println(Thread.currentThread().getId()+ " " + next());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }


    }

    private static int i = 0;

    private static MyLock myLock = new MyLock();

    private static int next() throws InterruptedException {
        try {
            myLock.lock();
            Thread.sleep(300);
            return i++;
        } catch (InterruptedException e) {
           throw e;
        } finally {
            myLock.unlock();
        }
    }
}
