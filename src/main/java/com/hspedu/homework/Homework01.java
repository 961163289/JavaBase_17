package com.hspedu.homework;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Homework01 {
    public static void main(String[] args) throws Exception {
        /**
         * 定义PrivateTest类，有私有name属性，并且属性值为hellokitty
         * 提供getName的公有方法
         * 创建PrivateTest的类，利用Class类得到私有的name属性，修改私有的name属性值，并调用getName()的方法打印name属性值
         */

        //方式一:
        //1.得到 PrivateTest 类对应的 Class 对象
        Class<?> testClass = Class.forName("com.hspedu.homework.PrivateTest");
        //2.创建对象
        Object o = testClass.newInstance(); //o 的运行类型就是 PrivateTest
        //3.使用反射操作 name属性
        Field name = testClass.getDeclaredField("name");
        //对name进行暴破,可以操作private属性
        name.setAccessible(true);
        System.out.println(name.get(o));
        //修改私有的name属性值
        name.set(o, "zi.peng");
        System.out.println(name.get(o));

        //4.得到 getName 方法对象
        Method getName = testClass.getDeclaredMethod("getName");
        System.out.println("方法打印 = " + getName.invoke(o));

        //方式二:
        //1. 得到 PrivateTest类对应的Class对象
        Class<PrivateTest> privateTestClass = PrivateTest.class;
        //2. 创建对象实例
        PrivateTest privateTestObj = privateTestClass.newInstance();
        //3. 得到name属性对象
        Field name2 = privateTestClass.getDeclaredField("name");//name属性是private
        //4. 暴破name
        name2.setAccessible(true);
        name2.set(privateTestObj, "天龙八部");
        //5. 得到getName方法对象
        Method getName2 = privateTestClass.getMethod("getName");
        //6. 因为getName() 是public，所有直接调用
        Object invoke = getName2.invoke(privateTestObj);
        System.out.println("name属性值=" + invoke);//天龙八部

    }
}

class PrivateTest {
    private String name = "hellokitty";

    public String getName() {
        return name;
    }
}
