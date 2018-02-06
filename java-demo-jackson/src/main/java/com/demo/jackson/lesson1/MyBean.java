package com.demo.jackson.lesson1;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

/**
 * This is {@link MyBean}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
@Data
// 序列化时，将按照顺序依次序列化
@JsonPropertyOrder({"phone", "name", "age"})
public class MyBean {

    private String name;

    private int age;

    private String phone;

    @JsonRawValue
    private String jsonInfo;

}
