package com.zhangshixu.java.demo.designpattern.creation.factory.v1;

import com.zhangshixu.java.demo.designpattern.creation.factory.v0.Circle;
import com.zhangshixu.java.demo.designpattern.creation.factory.v0.Rectangle;
import com.zhangshixu.java.demo.designpattern.creation.factory.v0.Shape;

/**
 * This is {@link Main2}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class Main2 {

    public static void main(String[] args) {
        ShapeFactoryV2 shapeFactory = new ShapeFactoryV2();
        Shape shape = (Circle)shapeFactory.getShape(Circle.class);
        shape.draw();

        shape = (Rectangle) shapeFactory.getShape(Rectangle.class);
        shape.draw();
    }

}
