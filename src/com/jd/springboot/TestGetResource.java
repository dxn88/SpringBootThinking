package com.jd.springboot;

import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.ClassUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import static org.springframework.core.io.support.SpringFactoriesLoader.FACTORIES_RESOURCE_LOCATION;

/**
 * @Auther: daixunan
 * @Date: 2018/10/5
 */

// 从resource中加载资源转化为properties，解析为类名
// 你以class为出发点，再结合相对路径的概念，就可以准确地定位资源文件了
public class TestGetResource {
    public static final String TEST_RESOURCE = "a/a/xx.properties";

    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> urls = (classLoader != null ?
                classLoader.getResources(FACTORIES_RESOURCE_LOCATION) :
                ClassLoader.getSystemResources(FACTORIES_RESOURCE_LOCATION));

        MultiValueMap<String, String> result = new LinkedMultiValueMap<>();
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            System.out.println("url.getPath() = " + url.getPath());
            System.out.println("url = " + url);
            UrlResource resource = new UrlResource(url);
            Properties properties = PropertiesLoaderUtils.loadProperties(resource);
            for (Map.Entry<?, ?> entry : properties.entrySet()) {
                List<String> factoryClassNames = Arrays.asList(
                        StringUtils.commaDelimitedListToStringArray((String) entry.getValue()));
                result.addAll((String) entry.getKey(), factoryClassNames);
            }
        }

        getProperties();
//        result.getOrDefault()
    }

    public static void getProperties(String... strs) throws IOException {
        Properties properties = new Properties();

//        properties.load(ClassUtils.getDefaultClassLoader().getResourceAsStream("xx.properties"));

        // 当前类(class)所在的包目录
        System.out.println(TestGetResource.class.getResource(""));
        // class path根目录
        System.out.println(TestGetResource.class.getResource("/"));

//        path不能以’/'开头时；
//        path是从ClassPath根下获取；
        System.out.println(TestGetResource.class.getClassLoader().getResources(""));
    }
}
