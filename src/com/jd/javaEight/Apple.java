package com.jd.javaEight;

import lombok.Data;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/12/5
 */

@Data
public class Apple {
    private String color;
    private int weight;

    private ProductPlace productPlace = new ProductPlace();

    public static String productString() {
        return "String";
    }
}
