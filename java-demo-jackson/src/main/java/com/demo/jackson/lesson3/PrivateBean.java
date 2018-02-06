package com.demo.jackson.lesson3;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is {@link PrivateBean}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//用来覆盖默认的关于哪些属性可见以及哪些属性不可见
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PrivateBean {

    private int id;
    private String name;

}
