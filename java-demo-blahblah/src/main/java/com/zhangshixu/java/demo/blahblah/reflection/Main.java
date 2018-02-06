//package com.zhangshixu.java.demo.blahblah.reflection;
//
//import com.zhangshixu.java.demo.blahblah.reflection.entity.Animal;
//import com.zhangshixu.java.demo.blahblah.reflection.entity.AnimalBark;
//import com.zhangshixu.java.demo.blahblah.reflection.entity.Cat;
//import com.zhangshixu.java.demo.blahblah.reflection.entity.Dog;
//
//import java.lang.reflect.Constructor;
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//
///**
// * This is {@link Main}.
// *
// * @author Zhang Shixu
// * @since 0.0.1
// */
//public class Main {
//
//    public static void main(String[] args) {
//
//        /**
//         * 三种获得 Class 对象的方式
//         */
//        System.out.println("################ 三种获得 Class 对象的方式 ################");
//
//        //第一种方式：
//        Class c1 = null;
//        Class c2 = null;
//        try {
//            c1 = Class.forName("com.zhangshixu.java.demo.blahblah.reflection.entity.AnimalBark");
//            //类名必须要使用完整包名，否则会报错
//            //c2 = Class.forName("SamePackageObj");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        System.out.println(c1);
//        System.out.println(c2);
//
//        //第二种方式：
//        //java中每个类型都有class 属性.
//        Class c3 = AnimalBark.class;
//        System.out.println(c3);
//
//        //第三种方式：
//        //java语言中任何一个java对象都有getClass 方法
//        AnimalBark animal = new Cat();
//        Class c4 = animal.getClass(); //c3是运行时类 (e的运行时类是Animal)
//        System.out.println(c4);
//
//
//        System.out.println();
//        System.out.println();
//        /**
//         * 构造函数
//         */
//        System.out.println("################ 构造函数 ################");
//
//        Class animalClass = Animal.class;
//
//        try {
//            Constructor<Dog> constructor = animalClass.getConstructor(String.class, Integer.class);
//            System.out.println(constructor.toString());
//            System.out.println(constructor.getName());
//            System.out.println(constructor.getParameterTypes());
//            System.out.println(constructor.isAccessible());
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println();
//        System.out.println();
//        /**
//         * 普通方法
//         */
//        System.out.println("################ 普通方法 ################");
//
//        try {
////            Method privateMethod = animalClass.getMethod("isReady", null);
////            System.out.println(privateMethod.isAccessible());
//
//            Method publicMethod = animalClass.getMethod("run", null);
//            System.out.println(publicMethod.isAccessible());
//            System.out.println(publicMethod.getReturnType());
//
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println();
//        System.out.println();
//        /**
//         * 属性
//         */
//        System.out.println("################ 属性 ################");
//
//        Field[] fields = animalClass.getFields();
//        for (Field field : fields) {
//            String name = field.getName();
//            Class type = field.getType();
//            //field.getBoolean()
//        }
//
//    }
//
//}
