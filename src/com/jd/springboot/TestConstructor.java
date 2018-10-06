package com.jd.springboot;

import org.springframework.boot.SpringApplication;

/**
 * @Auther: daixunan
 * @Date: 2018/10/5
 */

// 反射创建对象
public class TestConstructor {
    public static void main(String[] args) {
        Class<?>[] types = new Class<?>[] { SpringApplication.class, String[].class };
//        List<T> instances = new ArrayList<>(names.size());
//        Class<?> instanceClass = ClassUtils.forName(name, classLoader);
//        Assert.isAssignable(type, instanceClass);
//        Constructor<?> constructor = instanceClass
//                .getDeclaredConstructor(parameterTypes);
//        T instance = (T) BeanUtils.instantiateClass(constructor, args);
//        instances.add(instance);

        // StringUtils.commaDelimitedListToSet

    }
}
