package com.zhangshixu.java.demo.blahblah.reflection.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is {@link Animal}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {

    private String name;

    private Integer age;

    private String owner;

    public Animal(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void run() {

        isReady();

        System.out.println("left and right!");
    }

    private boolean isReady() {
//        do somethien here
        return true;
    }

}
