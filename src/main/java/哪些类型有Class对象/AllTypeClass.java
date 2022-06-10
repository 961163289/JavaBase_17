package 哪些类型有Class对象;

import java.io.Serializable;

public class AllTypeClass {
    public static void main(String[] args) {
        Class<String> cls1 = String.class;//外部类
        Class<Serializable> cls2 = Serializable.class;//接口
        Class<Integer[]> cls3 = Integer[].class;//数组
        Class<float[][]> cls4 = float[][].class;//二维数组
        Class<Deprecated> cls5 = Deprecated.class;//注解
        Class<Thread.State> cls6 = Thread.State.class;//枚举
        Class<Long> cls7 = long.class;//基本数据类型
        Class<Void> cls8 = void.class;//void
        Class<Class> cls9 = Class.class;//Class

        System.out.println(cls1);//java.lang.String
        System.out.println(cls2);//java.io.Serializable
        System.out.println(cls3);//[Ljava.lang.Integer;
        System.out.println(cls4);//[[F
        System.out.println(cls5);//java.lang.Deprecated
        System.out.println(cls6);//java.lang.Thread$State
        System.out.println(cls7);//long
        System.out.println(cls8);//void
        System.out.println(cls9);//java.lang.Class
    }
}
