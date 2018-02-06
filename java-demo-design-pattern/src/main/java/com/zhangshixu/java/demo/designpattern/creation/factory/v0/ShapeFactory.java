package com.zhangshixu.java.demo.designpattern.creation.factory.v0;

/**
 * This is {@link ShapeFactory}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class ShapeFactory {

    public Shape getShape(int type) {

        switch (type) {
            case 1: return new Square();
            case 2: return new Rectangle();
            case 3: return new Circle();
        }

        return null;

    }

}
