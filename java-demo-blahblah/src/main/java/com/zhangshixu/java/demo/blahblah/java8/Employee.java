package com.zhangshixu.java.demo.blahblah.java8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

/**
 * This is {@link Employee}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
@AllArgsConstructor
@Data
public class Employee {

    private Integer employeeNumber;
    private String employeeFirstName;
    private String employeeLastName;
    private LocalDate hireDate;

}
