package com.jd.netty;

import org.springframework.util.Assert;
import org.springframework.validation.ObjectError;

import java.lang.reflect.InvocationTargetException;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/11/13
 */
public class TestObjectFactory<C> implements ObjectFactory<C>{

    private final Class<? extends C> clazz;

    public TestObjectFactory(Class<? extends C> clazz) {
        Assert.notNull(clazz, "clazz is null When init TestObjectFactory");
        this.clazz = clazz;
    }

    @Override
    public C newObject() {
        try {
            return clazz.newInstance();
        } catch (Throwable e) {
            throw new ObjectCreateException("create Object failed from TestObjectFactory " + clazz, e);
        }
    }

//    @Override
//    public String toString() {
//        return StringUtil.simpleClassName(clazz) + ".class";
//    }
}



interface ObjectFactory<T extends Object>{
    T newObject();
}