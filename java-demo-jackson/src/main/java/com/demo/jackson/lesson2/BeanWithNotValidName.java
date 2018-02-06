package com.demo.jackson.lesson2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is {@link BeanWithNotValidName}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeanWithNotValidName {

    String id;

    String name;

    //这个属性是不合理命名，jackson在反序列化时候可能会导致类型错误
    String selected;

}
