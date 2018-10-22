package com.jd.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @Auther: daixunan
 * @Date: 2018/10/22
 */

/**
 *  可以用lombok的@Sl4f 去代替此方案，此方案比用*.class要好
 *  代码来源SimpleAliasRegistry
 */
public class TestLogger {
    protected final Log logger = LogFactory.getLog(getClass());

}


