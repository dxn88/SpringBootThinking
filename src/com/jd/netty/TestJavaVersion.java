package com.jd.netty;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/11/13
 */
public class TestJavaVersion {

    static Unsafe UNSAFE;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Unsafe unsafe  = (Unsafe) field.get(null);
            UNSAFE = unsafe;
        } catch (Exception e) {
        }
    }


    public static void main(String[] args) throws InstantiationException {
        TestJavaVersion instance = (TestJavaVersion) UNSAFE.allocateInstance(TestJavaVersion.class);
        int version = instance.majorVersionFromJavaSpecificationVersion();
        System.out.println("i = " + version);
    }

    public int majorVersionFromJavaSpecificationVersion() {
        return majorVersion(System.getProperty("java.specification.version", "1.6"));
    }

    // Package-private for testing only
    static int majorVersion(final String javaSpecVersion) {
        final String[] components = javaSpecVersion.split("\\.");
        final int[] version = new int[components.length];
        for (int i = 0; i < components.length; i++) {
            version[i] = Integer.parseInt(components[i]);
        }

        if (version[0] == 1) {
            assert version[1] >= 6;
            return version[1];
        } else {
            return version[0];
        }
    }
}
