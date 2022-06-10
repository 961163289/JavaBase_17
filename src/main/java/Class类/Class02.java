package Class类;

import com.hspedu.Car;

import java.lang.reflect.Field;

public class Class02 {
    public static void main(String[] args) throws Exception {
        String classAllPath = "com.hspedu.Car";
        //1.获取到 Car类 对应的 Class对象
        //<?> 表示不确定的 Java类型
        Class<?> cls = Class.forName(classAllPath);
        //2.输出 cls
        System.out.println(cls);//显示 cls对象,是哪个类的 Class 对象 com.hspedu.Car
        System.out.println(cls.getClass());//输出 cls 运行类型 java.lang.Class
        //3.得到包名
        System.out.println(cls.getPackage().getName());//com.hspedu
        //4.得到全类名
        System.out.println(cls.getName());//com.hspedu.Car
        //5.通过 cls 创建对象实例
        Car car = (Car) cls.newInstance();
        System.out.println(car);//car.toString()
        //6.通过反射获取属性 brand
        Field brand = cls.getField("brand");
        System.out.println(brand.get(car));
        //7.通过反射给属性赋值
        brand.set(car, "奔驰");
        System.out.println(brand.get(car));
        //8.得到所有的属性
        System.out.println("======所有的字段属性======");
        Field[] fields = cls.getFields();
        for (Field f : fields) {
            System.out.println(f.getName());//名称
        }
    }
}
