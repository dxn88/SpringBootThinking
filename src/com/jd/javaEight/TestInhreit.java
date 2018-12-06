package com.jd.javaEight;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/12/6
 */
public class TestInhreit {
    public static void main(String[] args) {
        C c = new C();
        c.hello();
    }
}


interface A{
    default void hello(){
        System.out.println("A");
    }
}

class B implements A {
    @Override
   public void hello() {
        System.out.println("B");
    }
}

class C extends B{
    @Override
    public void hello() {
        //这里怎么调用A的hello方法？
    }
}