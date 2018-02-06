package com.demo.jackson.lesson2;

import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

/**
 * This is {@link DeserializationTest}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class DeserializationTest {

    @Test
    public void testJsonCreator() throws IOException {
        String json = "{\"id\":1,\"theName\":\"My Bean\"}";
        BeanWithCreator bean = new ObjectMapper().readerFor(BeanWithCreator.class).readValue(json);
        assertEquals("My Bean", bean.name);
    }

    @Test
    public void whenDeserializingUsingJsonInject_thenCorrect()
            throws IOException {

        String json = "{\"name\":\"My bean\"}";
        InjectableValues inject = new InjectableValues.Std()
                .addValue(int.class, 1);
        BeanWithInject bean = new ObjectMapper().reader(inject)
                .forType(BeanWithInject.class)
                .readValue(json);

        assertEquals("My bean", bean.name);
        assertEquals(1, bean.id);
    }

    @Test
    public void testJsonSetter() throws IOException {

        String json = "{\"id\":1,\"theName\":\"My bean\"}";

        MyBean bean = new ObjectMapper()
                .readerFor(MyBean.class)
                .readValue(json);
        assertEquals("My bean", bean.getName());
    }

    @Test
    public void testCustomDeserialize() throws IOException {
        String json
                = "{\"name\":\"party\",\"eventDate\":\"20-12-2014 02:30:00\"}";

        SimpleDateFormat df
                = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        Event event = new ObjectMapper()
                .readerFor(Event.class)
                .readValue(json);

        assertEquals(
                "20-12-2014 02:30:00", df.format(event.eventDate));
    }

    @Test
    public void testBeanWithNotValidName() throws IOException {
        String json = "{\"id\": \"1\", \"name\": \"someone\", \"selected\": \"main-tab\"}";
        BeanWithNotValidName bean = new ObjectMapper().readerFor(BeanWithNotValidName.class).readValue(json);
        assertEquals(bean.getSelected(), "main-tab");
        System.out.println("#############################");
        System.out.println("this is the test of testBeanWithNotValidName");
        System.out.println(bean);
        System.out.println("#############################");
    }


}
