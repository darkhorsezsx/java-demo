package com.demo.jackson.lesson3;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.attribute.standard.MediaSize;

/**
 * This is {@link User}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    public int id;
    public Name name;

    // TODO: 2017/12/12 查询具体使用场景，是否仅限内部类？
    //将所标注的类型都忽略掉
    @JsonIgnoreType
    public static class Name {

        public Name(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String firstName;
        public String lastName;
    }

}
