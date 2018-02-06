package com.demo.jackson.lesson3;

import com.fasterxml.jackson.annotation.JsonInclude;
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
//用于将 空值/null值/默认值的属性排除
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MyBean {
    public int id;
    public String name;
}
