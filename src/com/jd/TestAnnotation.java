package com.jd;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Indexed;

import java.lang.annotation.Documented;
import java.lang.reflect.Method;
import java.util.jar.Attributes;

/**
 * @Auther: daixunan
 * @Date: 2018/10/6
 */

// 参考资料 https://blog.csdn.net/sinat_38259539/article/details/71799078
// 1. *.class 和 全类名 Class.forName() 的区别？

//    RTTI，编译器在编译时打开和检查.class文件
//            反射，运行时打开和检查.class文件

@Component("Haha")
public class TestAnnotation {

    @Autowired
    private String ele;

    public static void main(String[] args) throws NoSuchMethodException {


        Component annotation = AnnotationUtils.findAnnotation(TestAnnotation.class, Component.class);
        if (annotation != null) {
            System.out.println("annotation = " + annotation);
            System.out.println("annotation.value() = " + annotation.value());
        }

        // 注解的原始类型
        System.out.println("annotation = " + annotation.annotationType());
        // 重复合注解中获取原始注解
        Indexed indexed = AnnotationUtils.getAnnotation(annotation, Indexed.class);
        System.out.println("indexed.annotationType() = " + indexed.annotationType());

        // AnnotatedElement 可以接受注解的元素
        Method print = TestAnnotation.class.getMethod("print");

        Autowired autowired = print.getAnnotation(Autowired.class);
        System.out.println("annotation1.annotationType() = " + autowired.annotationType());
        // AnnotationUtils 会递归的获取注解 而不是declared注解
        Documented documented = AnnotationUtils.getAnnotation(print, Documented.class);
        System.out.println("documented.annotationType() = " + documented.annotationType());

//        TestAnnotation.class.getAnnotati

    }

    @Autowired
    public static void print() {

    }

}
