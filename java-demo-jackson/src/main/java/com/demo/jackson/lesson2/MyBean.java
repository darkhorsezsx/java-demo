package com.demo.jackson.lesson2;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;
import lombok.Getter;

/**
 * This is {@link MyBean}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
@Getter
public class MyBean {

    public int id;
    private String name;

    //Deserialization时候映射json中与属性名不匹配的字段，如将json中的 theName 映射为实体中的 name 属性
    @JsonSetter("theName")
    public void setTheName(String name) {
        this.name = name;
    }

}
