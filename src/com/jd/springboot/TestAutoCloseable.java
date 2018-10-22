package com.jd.springboot;

/**
 * @Auther: daixunan
 * @Date: 2018/10/22
 */

/**
 *  在try中使用必须继承AutoCloseable接口，并且在结束时会自动调用close()
 */
public class TestAutoCloseable implements AutoCloseable{


    public static void main(String[] args) throws Exception {

        try(TestAutoCloseable t = new TestAutoCloseable();
            TestAutoCloseable ta = new TestAutoCloseable()
        ) {

        }
    }


    @Override
    public void close() throws Exception {
        System.out.println("TestAutoCloseable.close");
    }
}
