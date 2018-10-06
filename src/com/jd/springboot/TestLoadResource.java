package com.jd.springboot;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @Auther: daixunan
 * @Date: 2018/10/6
 */

//  资源转成Object ，具体用的时候在用 instanceof判断类型， instanceof会根据实际类型 new 实际类型 判断类型，在强转对应类型

public class TestLoadResource {

    public static void main(String[] args) {

    }


    private int load(Object source) {
        Assert.notNull(source, "Source must not be null");
        if (source instanceof Class<?>) {
            return load((Class<?>) source);
        }
        if (source instanceof Resource) {
            return load((Resource) source);
        }
        if (source instanceof Package) {
            return load((Package) source);
        }
        if (source instanceof CharSequence) {
            return load((CharSequence) source);
        }
        throw new IllegalArgumentException("Invalid source type " + source.getClass());
    }
}
