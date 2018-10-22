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
 *  参考资料 https://blog.csdn.net/gongjds/article/details/78476652
 */
public class TestLogger {
    private final Log logger = LogFactory.getLog(getClass());

    public static void main(String[] args) {

    }

    private void print() {
        // 可以节省字符串的拼接， 虽然在方法里面已经进行判断是否打印日志
        if (logger.isInfoEnabled()) {
            logger.info("logger " + "test" );
        }
    }
}


