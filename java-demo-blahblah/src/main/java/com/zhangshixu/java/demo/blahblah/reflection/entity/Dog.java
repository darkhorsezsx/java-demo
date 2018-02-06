package com.zhangshixu.java.demo.blahblah.reflection.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is {@link Dog}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dog extends Animal implements AnimalBark {

    private String dogToy;

    public void bark() {
        System.out.println("wolf wolf!!");
    }

}
