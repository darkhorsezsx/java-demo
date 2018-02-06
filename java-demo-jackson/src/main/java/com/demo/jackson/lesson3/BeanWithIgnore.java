package com.demo.jackson.lesson3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is {@link BeanWithIgnore}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//官方的介绍是在类级别上忽略这个属性
@JsonIgnoreProperties({ "id" })
public class BeanWithIgnore {

    public int id;
    public String name;

    //在属性级别上忽略此属性
    @JsonIgnore
    public int age;
    public String address;

}
