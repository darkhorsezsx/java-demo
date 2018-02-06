package com.demo.jackson.lesson1;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

/**
 * This is {@link MyBeanForRootValue}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
@Data
// 序列化时，将使用设置的value值将实体属性封装起来
@JsonRootName(value = "myBean")
public class MyBeanForRootValue {

    private Integer id;

    private String name;

}
