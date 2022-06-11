package com.hspedu.reflection;

import java.lang.reflect.Constructor;

/**
 * 演示通过反射创建对象实例
 */
public class ReflecCreateInstance {
    public static void main(String[] args) throws Exception {
        //1.先获取到 User类的 Class对象
        Class<?> userClass = Class.forName("com.hspedu.reflection.User");
        //2.通过public的无参构造器创建实例
        Object o = userClass.newInstance();
        System.out.println(o);

        //3.通过public的有参构造器创建实例
        //3.1 先得到对应的构造器
        Constructor<?> constructor = userClass.getConstructor(String.class);
        //3.2 创建实例,并传入实参
        Object hsp = constructor.newInstance("hsp");
        System.out.println("hsp = " + hsp);

        //4.通过非public的有参构造器创建实例
        //4.1 得到private的构造器对象
        Constructor<?> constructor1 = userClass.getDeclaredConstructor(int.class, String.class);
        //4.2 创建实例
        //暴破 [暴力破解], 使用反射可以访问 private 构造器/方法/属性,反射面前,都是纸老虎
        constructor1.setAccessible(true);
        Object user2 = constructor1.newInstance(100, "张三丰");
        System.out.println("user2 = " + user2);
    }
}

class User {
    private int age;
    private String name = "zi.peng";

    //无参 public
    public User() {
    }

    //有参构造器 public
    public User(String name) {
        this.name = name;
    }

    //有参构造器 private
    private User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
