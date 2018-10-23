package com.jd.spring;

/**
 * @Auther: daixunan
 * @Date: 2018/10/23
 */

/**
 * spring 加载bean的aware原理
 */
public class TestAware {

    public static void main(String[] args) {
        Spring spring = new Spring();
//        ResourceAware resourceAware = (aware)->{};
        spring.init(new MyObj());
        spring.init(aware -> {
            System.out.println("this is " + aware);
        });
    }
}

class MyObj implements ResourceAware {
    @Override
    public void setResourceAware(String aware) {
        System.out.println("aware = " + aware);
    }
}

@FunctionalInterface
interface ResourceAware{
    void setResourceAware(String aware);
}

class Spring{

    public void init(ResourceAware bean) {

        if (bean instanceof ResourceAware) {
            ((ResourceAware)bean).setResourceAware("ResourceAware");
        }
    }
}
