package com.jd.springboot;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * @Auther: daixunan
 * @Date: 2018/10/5
 */
public class TestIdentityHashMap {

    public static void main(String[] args) {
        // IdentityHashMap只根据key的值相当判断k1==k2
        IdentityHashMap<String,Object> map = new IdentityHashMap<String,Object>();

        map.put(new String("xx"), "first");
        map.put(new String("xx"), "second");
        map.put("xx", "firstxx");
        map.put("xx", "secondxx");

        for(Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.print(entry.getKey() + "    ");
            System.out.println(entry.getValue());
        }
    }
}
