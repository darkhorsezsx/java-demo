package com.demo.jackson.lesson5;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is {@link MyBean}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyBean {

    public int id;
    private String name;

    //@JsonProperty 用于指明JSON中的属性名，序列化和反序列化均可以用
    @JsonProperty("name")
    public void setTheName(String name) {
        this.name = name;
    }

    @JsonProperty("name")
    public String getTheName() {
        return name;
    }
}
