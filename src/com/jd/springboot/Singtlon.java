package com.jd.springboot;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: daixunan
 * @Date: 2018/10/21
 */
public class Singtlon {

    private static Singtlon singtlon = new Singtlon();
    /**
     *  非常重要 所有静态资源都要放在单利模式的前面去加载 ************
     *  如果把singtlon放上面将会报错
     */

    private static List<String> strings = new ArrayList<>();

    public Singtlon() {
        strings.add("hello");
    }

    public static Singtlon getSingtlon() {

        return singtlon;
    }

    public void print() {
        for (String string : strings) {
            System.out.println("string = " + string);
        }
    }

}
