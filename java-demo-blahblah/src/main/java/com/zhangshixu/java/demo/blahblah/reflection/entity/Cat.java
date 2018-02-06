package com.zhangshixu.java.demo.blahblah.reflection.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is {@link Cat}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cat extends Animal implements AnimalBark {

    private String catToy;

    public void bark() {
        System.out.println("Meow Meow!!");
    }


}
