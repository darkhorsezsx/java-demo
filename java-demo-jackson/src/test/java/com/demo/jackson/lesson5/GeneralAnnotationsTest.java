package com.demo.jackson.lesson5;

import com.demo.jackson.lesson5.jsonview.Item;
import com.demo.jackson.lesson5.jsonview.Views;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.matchers.JUnitMatchers.containsString;

/**
 * This is {@link GeneralAnnotationsTest}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class GeneralAnnotationsTest {

    @Test
    public void testJsonProperty() throws IOException {
        MyBean bean = new MyBean(1, "My bean");

        String result = new ObjectMapper().writeValueAsString(bean);

        assertThat(result, containsString("My bean"));
        assertThat(result, containsString("1"));

        MyBean resultBean = new ObjectMapper()
                .readerFor(MyBean.class)
                .readValue(result);
        assertEquals("My bean", resultBean.getTheName());
    }

    @Test
    public void testJsonFormat() throws ParseException, JsonProcessingException {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));

        String toParse = "20-12-2014 02:30:00";
        Date date = df.parse(toParse);
        Event event = new Event("party", date);

        String result = new ObjectMapper().writeValueAsString(event);

        assertThat(result, containsString(toParse));
    }

    @Test
    public void testUnWrapped() throws JsonProcessingException {
        UnwrappedUser.Name name = new UnwrappedUser.Name("John", "Mike");
        UnwrappedUser user = new UnwrappedUser(1, name);
        ObjectMapper mapper = new ObjectMapper();

        String result = mapper.writeValueAsString(user);
        System.out.println("this is the test of JsonUnwrapped: ");
        System.out.println(result);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        assertThat(result, containsString("John"));
    }

    @Test
    public void testJsonView() throws JsonProcessingException {
        Item item = new Item(2, "book", "John");

        String result = new ObjectMapper()
                .writerWithView(Views.Public.class)
                .writeValueAsString(item);

        System.out.println("this is the test of JsonView: " + result);

        assertThat(result, containsString("book"));
        assertThat(result, containsString("2"));
        assertThat(result, not(containsString("John")));
    }

}
