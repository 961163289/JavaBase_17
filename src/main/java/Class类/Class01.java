package Class类;

public class Class01 {
    public static void main(String[] args) throws Exception {
        /*
        ClassLoader 类,仍然是通过 ClassLoader 类加载 Cat类的 Class 对象
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            return loadClass(name, false);
        }
        */
        //1.Class也是类,因此也继承 Object类
        //2.Class类对象不是 new出来的,而是系统创建的
        //3.对于某个类的 Class 类对象,在内存中只有一份,因为类只加载一次
        Class cls1 = Class.forName("com.hspedu.Cat");
        System.out.println(cls1.hashCode());
        Class cls2 = Class.forName("com.hspedu.Cat");
        System.out.println(cls2.hashCode());
        Class cls3 = Class.forName("com.hspedu.Cat");
        System.out.println(cls3.hashCode());
    }
}
