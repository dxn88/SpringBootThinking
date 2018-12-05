package com.jd.javaEight;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/12/5
 */
public class lamdaUsage {

    interface Adder{
        long add(int first, int second);
    }

    @FunctionalInterface
    interface NothingAdder extends Adder{
        @Override
        default long add(int first, int second) {
            return 0;
        }

        long multi(int a, int b);
    }

    public static void main(String[] args) {
        Predicate<Apple> applePredicate ;
        Consumer<Apple> appleConsumer;
        Function<Apple, Boolean> appleBooleanFunction;
        Supplier<Apple> appleSupplier;

        BiFunction biFunction;

        List<Apple> apples = new ArrayList<>();

        Apple apple = new Apple();
        apple.setColor("green");
        apple.setWeight(100);
        Apple apple1 = new Apple();
        apple1.setColor("red");
        apple1.setWeight(100);
        apples.add(apple);
        apples.add(apple1);

        List<Apple> red = findApple(apples, appleVal -> appleVal.getColor().equals("red"));
        System.out.println("red = " + red);

        BiFunction<String, Integer, Character> f2 = String::charAt;

        // 便便写法  String s -> s.length()     简写 String::length
        // 你有个对象Object     ()- Object.func 简写  Object::func
        // 下面在演示一下lambda表达式的重构
        // @1  (args)-> ClassName.staticMethod(args)  简写 ClassName::staticMethod
        Consumer<Apple> appleConsumer1 = lamdaUsage::printApple;
        appleConsumer1.accept(apple);
        // @2  (arg0, rest) -> {arg0.instanceMethod(rest)} 简写 ClassName::instanceMethod
        lamdaUsage lamdaUsage = new lamdaUsage();
        Function<Apple, String> appleStringFunction = lamdaUsage::getAppleColor;
        System.out.println("appleStringFunction.apply(apple) = " + appleStringFunction.apply(apple));
        // @3  (args) -> {exp.instanceMethod(args)} 简写  exp::instanceMethod
        Consumer<Apple> appleConsumer2 = lamdaUsage::doPrintWeight;
        appleConsumer2.accept(apple);

    }

    public static void printApple(Apple apple) {
        System.out.println("apple = " + apple);
    }

    public String getAppleColor(Apple apple) {
        return apple.getColor();
    }

    public void doPrintWeight(Apple apple) {
        System.out.println("apple.setWeight(): = " + apple.getWeight());
    }

    public static List<Apple> findApple(List<Apple> apples, Predicate<Apple> applePredicate) {

        List<Apple> greenApples = new ArrayList<>();

        apples.forEach( apple -> {
            if (applePredicate.test(apple)) {
                greenApples.add(apple);
            }

        });

        return greenApples;
    }
}
