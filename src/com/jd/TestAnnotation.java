package com.jd;

import lombok.Data;

import java.lang.annotation.*;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2019/1/12
 */
@Data
@RuntimeAnnotation
public class TestAnnotation {
    public static void main(String[] args) {
        RuntimeAnnotation annotation = TestAnnotation.class.getAnnotation(RuntimeAnnotation.class);
        System.out.println("annotation = " + annotation);
        Class<? extends Annotation> aClass = annotation.annotationType();
        System.out.println("aClass = " + aClass);
    }

    public static void print(){}
}
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface RuntimeAnnotation{

}
