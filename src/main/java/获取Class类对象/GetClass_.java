package 获取Class类对象;

import com.hspedu.Car;

public class GetClass_ {
    public static void main(String[] args) throws Exception {
        //1.Class.forName
        String classAllPath = "com.hspedu.Car";//通过读取配置文件获取
        Class<?> cls1 = Class.forName(classAllPath);
        System.out.println(cls1);//com.hspedu.Car

        //2.类名.class , 应用场景: 用于参数传递
        Class cls2 = Car.class;
        System.out.println(cls2);//com.hspedu.Car

        //3.对象.getClass() , 应用场景,有对象实例
        Car car = new Car();
        Class cls3 = car.getClass();
        System.out.println(cls3);//com.hspedu.Car

        //4.通过类加载器,来获取到类的 Class 对象
        //(1)先得到类加载器
        ClassLoader classLoader = car.getClass().getClassLoader();
        //(2)通过类加载器得到 Class 对象
        Class cls4 = classLoader.loadClass(classAllPath);
        System.out.println(cls4);//com.hspedu.Car

        //cls1,cls2,cls3,cls4 其实是同一个对象
        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());
        System.out.println(cls3.hashCode());
        System.out.println(cls4.hashCode());

        //5.基本数据（int，char，boolean，float，double，byte，long，short），按如下方式得到 Class 类对象
        Class<Integer> integerClass = int.class;
        Class<Character> charClass = char.class;
        Class<Boolean> booleanClass = boolean.class;
        System.out.println(integerClass);//int

        //6.基本数据类型对应的包装类，可以通过 .TYPE 得到 Class 类对象
        Class<Integer> type1 = Integer.TYPE;
        Class<Character> type2 = Character.TYPE; //其他包装类 BOOLEAN, DOUBLE, LONG, BYTE 等
        System.out.println(type1);

        //integerClass,type1 其实是同一个对象
        System.out.println(integerClass.hashCode());
        System.out.println(type1.hashCode());
    }
}
