package com.jd;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.util.jar.Attributes;

/**
 * @Auther: daixunan
 * @Date: 2018/10/6
 */

//AnnotationConfigUtils
public class TestAnnotation {

    public static void main(String[] args) {
        String name = "com.jd";
        Package aPackage = Package.getPackage(name);
        Attributes.Name name1 = new Attributes.Name("");

        System.out.println("aPackage = " + aPackage.getImplementationTitle());
        System.out.println("aPackage.getName() = " + aPackage.getName());
        Component annotation = AnnotationUtils.findAnnotation(TestLoadResource.class, Component.class);
        if (annotation != null) {
            System.out.println("annotation = " + annotation);
        }
    }


}
