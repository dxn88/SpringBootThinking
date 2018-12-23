package com.jd;

import lombok.Data;
import lombok.SneakyThrows;
import lombok.ToString;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/12/23
 */
public class TestClone {

    public static void main(String[] args) {
        Fruit f = new Apple();
        ((Apple) f).setName("aaa");
        Fruit b = (Apple) f.clone();
        System.out.println("b = " + b);
    }


}


abstract class Fruit implements Cloneable {

    @SneakyThrows
    @Override
    protected Object clone() {
        return super.clone();
    }
}

@ToString
@Data
class Apple extends Fruit {
    private String name = "apple";
}

@ToString
@Data
class Orange extends Fruit {
    private String name = "Orange";
}