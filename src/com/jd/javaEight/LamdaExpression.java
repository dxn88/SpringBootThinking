package com.jd.javaEight;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/12/5
 */
public class LamdaExpression<T> {

    public static void main(String[] args) {
        Comparator<Apple> appleComparator = (a1, a2) -> a1.getColor().compareTo(a2.getColor());
        Comparator<Apple> appleComparator2 = Comparator.comparing(Apple::getColor);

//        Predicate<Apple> p = a -> a.getColor().equals("red");

        List<Apple> apples = new ArrayList<>();
        Apple apple = new Apple();
        apple.setColor("green");
        apple.setWeight(100);
        Apple apple1 = new Apple();
        apple1.setColor("red");
        apple1.setWeight(100);
        apples.add(apple);
        apples.add(apple1);


        apples.sort(appleComparator);
        System.out.println("apples = " + apples);

        // T入参，R返回结果
        Function<String, Integer> function = s -> s.length();

        Function<Apple, Boolean> f = a -> a.getColor().equals("red");

        // 虽然是一个类型，但是不能强转 XXX
//        Predicate<Apple> applePredicate = (Predicate<Apple>)f;
//        System.out.println("applePredicate = " + applePredicate.test(apple1));

        Supplier<String> appleSupplier = Apple::productString;

        System.out.println("appleSupplier = " + appleSupplier.get());

    }


}
