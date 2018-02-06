package com.demo.jackson.lesson3;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

/**
 * This is {@link PropertyInclusionTest}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class PropertyInclusionTest {

    @Test
    public void testIgnoreProperty() throws JsonProcessingException {
        BeanWithIgnore bean = new BeanWithIgnore(1, "My bean", 20, "street one");

        String result = new ObjectMapper()
                .writeValueAsString(bean);
        System.out.println("this the test for JsonIgnore: " + result);

        assertThat(result, containsString("My bean"));
        assertThat(result, not(containsString("id")));
        assertThat(result, not(containsString("age")));
    }

    @Test
    public void testJsonIgnoreType() throws JsonProcessingException {
        User.Name name = new User.Name("John", "Doe");
        User user = new User(1, name);

        String result = new ObjectMapper()
                .writeValueAsString(user);

        assertThat(result, containsString("1"));
        assertThat(result, not(containsString("name")));
        assertThat(result, not(containsString("John")));
    }

    @Test
    public void testJsonInclude() throws JsonProcessingException {
        MyBean bean = new MyBean(1, null);

        String result = new ObjectMapper()
                .writeValueAsString(bean);

        assertThat(result, containsString("1"));
        assertThat(result, not(containsString("name")));



        bean = new MyBean(0, "John");
        result = new ObjectMapper()
                .writeValueAsString(bean);

        assertThat(result, not(containsString("1")));
        assertThat(result, containsString("name"));
    }

    @Test
    public void testJsonAutoDetect() throws JsonProcessingException {
        PrivateBean bean = new PrivateBean(1, "My bean");

        String result = new ObjectMapper()
                .writeValueAsString(bean);

        assertThat(result, containsString("1"));
        assertThat(result, containsString("My bean"));
    }

}
