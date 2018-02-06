package com.zhangshixu.java.demo.blahblah.java8;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is {@link SortTest}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class SortTest {

    List<Employee> employees;

    @Before
    public void setup() {

        employees = new ArrayList<>();
        employees.add(new Employee(123, "Jack", "Johnson", LocalDate.of(1988, Month.APRIL, 12)));
        employees.add(new Employee(345, "Cindy", "Bower", LocalDate.of(2011, Month.DECEMBER, 15)));
        employees.add(new Employee(567, "Perry", "Node", LocalDate.of(2005, Month.JUNE, 07)));
        employees.add(new Employee(467, "Pam", "Krauss", LocalDate.of(2005, Month.JUNE, 07)));
        employees.add(new Employee(435, "Fred", "Shak", LocalDate.of(1988, Month.APRIL, 17)));
        employees.add(new Employee(678, "Ann", "Lee", LocalDate.of(2007, Month.APRIL, 12)));
    }

    @Test
    public void testComparator() {
        Comparator<Employee> byHireDate = new Comparator<Employee>() {
            public int compare(Employee left, Employee right) {
                if (left.getHireDate().isBefore(right.getHireDate())) {
                    return -1;
                } else {
                    return 1;
                }
            }
        };

        Collections.sort(employees, byHireDate);
        System.out.println("============= testComparator =============");
        sout(employees);
    }

    @Test
    public void testAnonymoudInnerClass() {
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getEmployeeFirstName().compareTo(
                        o2.getEmployeeFirstName());
            }
        });
        System.out.println("============= testAnonymoudInnerClass =============");
        sout(employees);
    }

    @Test
    public void testLamdaExpression() {
        Comparator<Employee> byEmployeeNumber = (e1, e2) -> Integer.compare(
                e1.getEmployeeNumber(), e2.getEmployeeNumber());

        System.out.println("============= testLamdaExpression =============");
        employees.stream().sorted(byEmployeeNumber)
                .forEach(e -> System.out.println(e));
    }

    @Test
    public void testInlineLamdaExpression() {
        System.out.println("============= testInlineLamdaExpression =============");
        employees
                .stream()
                .sorted((e1, e2) -> Integer.compare(e1.getEmployeeNumber(),
                        e2.getEmployeeNumber()))
                .forEach(e -> System.out.println(e));
    }

    @Test
    public void testMultipleSort() {
        Comparator<Employee> byFirstName = (e1, e2) -> e1
                .getEmployeeFirstName().compareTo(e2.getEmployeeFirstName());

        Comparator<Employee> byLastName = (e1, e2) -> e1.getEmployeeLastName()
                .compareTo(e2.getEmployeeLastName());

        System.out.println("============= testMultipleSort =============");
        employees.stream().sorted(byFirstName.thenComparing(byLastName))
                .forEach(e -> System.out.println(e));
    }

    private void sout(List<Employee> employees) {
        for (Employee employee : employees)
            System.out.println(employee);
        System.out.println();
    }

}
