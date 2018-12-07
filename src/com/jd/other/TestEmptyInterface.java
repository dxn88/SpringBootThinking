package com.jd.other;

import lombok.ToString;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/12/7
 */
public class TestEmptyInterface {

    public static void main(String[] args) {
        Object[] objects = new Object[]{new OldMan(), new Jenpenese(), new Woman()};

        Arrays.stream(objects).forEach(Hunter::hunt);
//        List<Object> objectList = Arrays.asList(objects);
//        objectList.stream().forEach(Hunter::hunt);
//        Optional.ofNullable(objects).ifPresent(System.out::println);
    }

}


class Hunter{

     static void hunt(Object o) {

        if (o instanceof Human) {
            return;
        }
        System.out.println("hunter " + o);
    }
}


interface Human{}

@ToString
class Man implements Human {

}

@ToString
class Woman implements Human {

}

@ToString
class OldMan extends Man {
}

@ToString
class Jenpenese{

}