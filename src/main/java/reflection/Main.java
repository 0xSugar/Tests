package reflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException, ClassNotFoundException {
        // создание объекта, если у него его публичный конструктор.
        Class clazz = PrivateClass.class;
//        Class[] argsInConstructor = {String.class, int.class};
//        PrivateClass pc = (PrivateClass) clazz.getConstructor(argsInConstructor).newInstance("ks", 3); // работать не не будет для приватных конструторов
//        System.out.println(pc);

        // используем дефолтный public конструктор...
        PrivateClass romb = (PrivateClass) clazz.newInstance();
        System.out.println(romb);

        // изменение приватных полей
        Field name = clazz.getDeclaredField("name");
        Field age = clazz.getDeclaredField("age");
        name.setAccessible(true);   //  делаем поле доступным для изменения
        age.setAccessible(true);
        name.set(romb, "Ромб");     //  указываем для какого объекта и что присвоить
        age.set(romb, 10);
        System.out.println(romb);

        // получение и использование приватного метода
        Method testMethod = clazz.getDeclaredMethod("testMethod");
        testMethod.setAccessible(true); // разрешаем
        testMethod.invoke(romb);        // вызываем на romb
    }
}
