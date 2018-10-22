package com.jd.spring;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: daixunan
 * @Date: 2018/10/22
 */

/**
 * 代码来源SimpleAliasRegistry
 */
public class TestForEachAndStreamOper {

    private Map<String, String> aliasMap = new ConcurrentHashMap(8);


    /**
     * map直接foreach 递归查询
     * @param name
     * @param result
     */
    private void retrieveAliases(String name, List<String> result) {
        this.aliasMap.forEach((alias, registeredName) -> {
            if (registeredName.equals(name)) {
                result.add(alias);
                retrieveAliases(alias, result);
            }
        });
    }
}
