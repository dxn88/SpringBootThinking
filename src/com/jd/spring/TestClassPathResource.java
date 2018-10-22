package com.jd.spring;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;

/**
 * @Auther: daixunan
 * @Date: 2018/10/22
 */
public class TestClassPathResource {
    public static void main(String[] args) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("bean.xml");
        File file = classPathResource.getFile();
        byte[] bytes = FileCopyUtils.copyToByteArray(file);

        System.out.println("new String(bytes) = " + new String(bytes));

    }
}
