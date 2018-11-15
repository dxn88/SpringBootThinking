package com.jd.spring.testPostProcesser;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/11/15
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface RoutingInjected{
}
