package com.zhangshixu.java.demo.designpattern.creation.factory.v1;


import com.zhangshixu.java.demo.designpattern.creation.factory.v0.Shape;

/**
 * This is {@link ShapeFactoryV2}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class ShapeFactoryV2 {

    public static Object getShape(Class<?extends Shape> clazz) {
        Object obj = null;

        try {
            obj = Class.forName(clazz.getName()).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return obj;
    }

}
