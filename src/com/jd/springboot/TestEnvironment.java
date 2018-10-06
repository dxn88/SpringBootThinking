package com.jd.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @Auther: daixunan
 * @Date: 2018/10/5
 */

@Component
public class TestEnvironment {
    @Autowired
    Environment environment;

}
