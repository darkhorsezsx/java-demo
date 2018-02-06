package com.demo.jackson.lesson5;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is {@link UnwrappedUser}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnwrappedUser {

    public int id;

    @JsonUnwrapped
    public Name name;

    @AllArgsConstructor
    public static class Name {
        public String firstName;
        public String lastName;
    }

}
