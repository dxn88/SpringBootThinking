package com.jd.spring;

/**
 * @Auther: daixunan
 * @Date: 2018/10/24
 */
public class TestParentAndChildFunction {


    public static void main(String[] args) {

        // 子类的实现会覆盖父类的方法, 不管调用方法在子类中调用还是在父类中调用
        Child childc = new Child();
        Child child = new Parent();

    }
}


class Parent extends Child {
    @Override
    protected void print() {
        System.out.println("Parent.print");
    }
}

class Child{

    Child(){
        print();
    }

    protected void print() {
        System.out.println("Child.print");
    }
}