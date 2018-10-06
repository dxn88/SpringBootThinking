package com.jd;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

/**
 * @Auther: daixunan
 * @Date: 2018/10/6
 */
public class TestAnnotation {

    public static void main(String[] args) {
        Component annotation = AnnotationUtils.findAnnotation(TestLoadResource.class, Component.class);
        if (annotation != null) {
            System.out.println("annotation = " + annotation);
        }
    }
}
