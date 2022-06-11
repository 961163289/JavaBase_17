package com.hspedu.reflection;

import java.lang.reflect.Field;

public class ReflecAccessProperty {
    public static void main(String[] args) throws Exception {
        //1.得到 Student 类对应的 Class 对象
        Class<?> stuClass = Class.forName("com.hspedu.reflection.Student");
        //2.创建对象
        Object o = stuClass.newInstance(); //o 的运行类型就是 Student
        System.out.println(o.getClass()); //Student
        //3.使用反射得到 age属性对象
        Field age = stuClass.getField("age");
        age.set(o, 88);
        System.out.println(o);
        System.out.println(age.get(o));//返回 age属性的值
        //4.使用反射操作 name属性
        Field name = stuClass.getDeclaredField("name");
        //对name进行暴破,可以操作private属性
        name.setAccessible(true);
        //name.set(o,"zi.peng");
        name.set(null, "ZiPeng~");//因为name是static属性,因此o也可以写成null
        System.out.println(o);
        System.out.println(name.get(o));//获取属性值
        System.out.println(name.get(null));//获取属性值,要求name是static
    }
}

class Student {
    public int age;
    private static String name;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ",name=" + name +
                '}';
    }
}
