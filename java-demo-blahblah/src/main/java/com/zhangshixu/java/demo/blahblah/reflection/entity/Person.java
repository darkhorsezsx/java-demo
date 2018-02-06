package com.zhangshixu.java.demo.blahblah.reflection.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is {@link Person}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;

    private Animal animal;

}
