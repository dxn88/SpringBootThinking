package com.jd.springboot;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: daixunan
 * @Date: 2018/10/5
 */
public class TestMultiValueMap {
    public static void main(String[] args) {
        // 一个key对应多个value
        MultiValueMap multiValueMap = new LinkedMultiValueMap();

        multiValueMap.add("hello", "world");
        multiValueMap.add("hello", "China");

        Set<Map.Entry<Object, List<Object>> > set = multiValueMap.entrySet();
        for (Map.Entry<Object, List<Object>> entry : set) {

            for(Object obj : entry.getValue()){
                System.out.println("obj = " + obj);
            }

        }

    }
}
