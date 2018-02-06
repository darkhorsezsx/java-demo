package com.zhangshixu.java.demo.designpattern.creation.factory.v0;

/**
 * This is {@link Main}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class Main {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.getShape(1);
        shape.draw();

        shape = shapeFactory.getShape(2);
        shape.draw();
    }

}
