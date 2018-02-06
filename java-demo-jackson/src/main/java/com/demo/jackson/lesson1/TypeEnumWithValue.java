package com.demo.jackson.lesson1;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is {@link TypeEnumWithValue}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public enum TypeEnumWithValue {

    TYPE1(1, "TYPE A"), TYPE2(2, "TYPE B");

    private Integer id;
    private String name;

    TypeEnumWithValue(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //@JsonValue 注解标注一个方法，这个方法会用来序列化整个对象实例
    @JsonValue
    public String getName() {
        return name;
    }

}
