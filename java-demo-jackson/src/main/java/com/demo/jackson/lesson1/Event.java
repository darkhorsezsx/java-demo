package com.demo.jackson.lesson1;

import com.demo.jackson.lesson1.serializer.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.Date;

/**
 * This is {@link Event}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
@Data
public class Event {

    public String name;

    //用于指定自定义的序列化类，可用于方法，属性和类,
    // using 需要传入继承自 com.fasterxml.jackson.databind.annotation.JsonSerializer的子类
    @JsonSerialize(using = CustomDateSerializer.class)
    public Date eventDate;

}
