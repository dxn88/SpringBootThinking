package com.jd.spring;

import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther: daixunan
 * @Date: 2018/10/22
 */
public class TestClassPathResource {
    public static void main(String[] args) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("bean.xml");

        BufferedReader reader = new BufferedReader(new InputStreamReader(classPathResource.getInputStream(), "UTF-8")); // 实例化输入流，并获取网页代码
        String s; // 依次循环，至到读的值为空
        StringBuilder sb = new StringBuilder();
        while ((s = reader.readLine()) != null) {
            sb.append(s);
        }
        reader.close();
        String str = sb.toString();

        System.out.println("str = " + str);
    }
}
