package com.zhangshixu.java.demo.blahblah.lamda;

import lombok.Data;

/**
 * This is {@link Entity}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
@Data
public class Entity {
    private String name;
    private Integer age;

    public Entity(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
}
