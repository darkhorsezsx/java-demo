package com.demo.jackson.lesson2;

import com.fasterxml.jackson.annotation.JacksonInject;
import lombok.Data;

/**
 * This is {@link BeanWithInject}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
@Data
public class BeanWithInject {

    // TODO: 2017/12/6 不太明白
    @JacksonInject
    public int id;

    public String name;


}
