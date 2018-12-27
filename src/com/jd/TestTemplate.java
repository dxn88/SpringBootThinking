package com.jd;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/12/24
 */
public class TestTemplate {
    public static void main(String[] args) {

        Base<ParentA> parentABase = new ParentA();
        System.out.println("parentABase.getInstance().getClass() = " + parentABase.getInstance().getClass());
        parentABase.getInstance().printA().printA();
    }
}

/**
 * 对头 不管是在子类还是在父类返回的都是子类对象，父类继承这个方法
 * @param <T>
 */
abstract class Base<T> {
    public T getInstance() {
        return (T)this;
    }
}

class ParentA extends Base<ParentA>{

    public ParentA printA() {
        System.out.println("ParentA.print");
        return this;
    }
}

class ParentB extends Base<ParentB>{

}
