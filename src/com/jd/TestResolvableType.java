package com.jd;

import org.springframework.core.ResolvableType;

/**
 * @Auther: daixunan
 * @Date: 2018/10/5
 * @Data 参考资料 https://blog.csdn.net/zbw18297786698/article/details/73441623
 */

// 提供对泛型的更强大操作,包括对字段的泛型信息
public class TestResolvableType implements AA<String> {
    public static void main(String[] args) {
        ResolvableType resolvableType = ResolvableType.forClass(TestResolvableType.class);
        System.out.println(resolvableType);
        Class<?> resolve = resolvableType.getInterfaces()[0].getGeneric(0).resolve();
        System.out.println("resolve = " + resolve);
    }

}

interface AA<T>{}
