package com.jd.netty;

import com.sun.xml.internal.ws.api.model.CheckedException;
import sun.misc.Unsafe;

import java.io.IOException;
import java.lang.reflect.Field;

import static sun.misc.Unsafe.getUnsafe;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/11/13
 */
public class TestJavaVersion {

    static Unsafe UNSAFE;
    private String name = "dxn";

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Unsafe unsafe  = (Unsafe) field.get(null);
            UNSAFE = unsafe;
        } catch (Exception e) {
        }
    }


    public static void main(String[] args) throws Exception {
        TestJavaVersion instance = (TestJavaVersion) UNSAFE.allocateInstance(TestJavaVersion.class);
        int version = instance.majorVersionFromJavaSpecificationVersion();
        System.out.println("i = " + version);

        instance.print();
        Field name = instance.getClass().getDeclaredField("name");
        UNSAFE.putObject(instance, UNSAFE.objectFieldOffset(name), "huanghui");
        instance.print();

        getUnsafe().throwException(new NoSuchFieldException());
    }


    static void doThrow(Exception e) {
       doThrow0(e);
    }

    static <E extends Exception>
    void doThrow0(Exception e) throws E {
        throw (E) e;
    }

    public void print() throws Exception {

        System.out.println("name = " + name);
        throw new Exception("haha");
    }

    public void testPrint(){
        try {
            print();
        } catch (Exception e) {
//            getUnsafe().throwException(new IOException(e));
            throw new RuntimeException("wrapper");
        }
    }

    public void TestUnsafeExp() {
        try {
            testPrint();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
