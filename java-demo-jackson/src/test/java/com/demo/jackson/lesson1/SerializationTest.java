package com.demo.jackson.lesson1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * This is {@link SerializationTest}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class SerializationTest {

    /**
     * Serialize Tests
     *
     */

    @Test
    public void testJsonAnyGetter() throws JsonProcessingException {
        ExtendableBean bean = new ExtendableBean();
        bean.setName("test bean");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("age", 20);
        map.put("phone", "18812341234");
        bean.setProperties(map);

        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
    }

    @Test
    public void testJsonAnySetter() throws IOException {
        String json
                = "{\"name\":\"My bean\",\"attr2\":\"val2\",\"attr1\":\"val1\"}";

        ExtendableBean bean = new ObjectMapper()
                .readerFor(ExtendableBean.class)
                .readValue(json);

        assertEquals("My bean", bean.getName());
        assertEquals("val2", bean.getProperties().get("attr2"));
    }

    @Test
    public void testJsonGetter() throws JsonProcessingException {
        ExtendableBean bean = new ExtendableBean();
        bean.setName("test bean");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("age", 20);
        map.put("phone", "18812341234");
        bean.setProperties(map);

        String result = new ObjectMapper().writeValueAsString(bean);
        assertThat(result, containsString("customed"));
        /*
        * 从结果看，虽然ExtendableBean有自定义的getter,但是因为@JsonGetter("name")的存在，序列化时，
        * 属性name使用@JsonGetter注解标注的方法，而不是默认的
        * */
    }

    @Test
    public void testJsonPropertyOrder() throws JsonProcessingException {
        MyBean myBean = new MyBean();
        myBean.setAge(12);
        myBean.setName("Jack");
        myBean.setPhone("18812341234");
        myBean.setJsonInfo("{\"attr\": false}");

        String result = new ObjectMapper().writeValueAsString(myBean);

        System.out.println("this is the test for JsonPropertyOrder: " + result);

        //可以确认 序列化时候的输出顺序为 phone name age, 与在MyBean注解一致
        int indexOfPhone = result.indexOf("phone");
        int indexOfName = result.indexOf("name");
        int indexOfAge = result.indexOf("age");
        assertTrue(indexOfPhone < indexOfName);
        assertTrue(indexOfName < indexOfAge);

        //可以确认 将jsonInfo字段进行原样序列化输出
        assertThat(result, containsString("{\"attr\": false}"));
    }

    @Test
    public void testJsonValue() throws JsonProcessingException {

        String enumString = new ObjectMapper().writeValueAsString(TypeEnumWithValue.TYPE1);
        System.out.println("this the test for JsonValue: " + enumString);
        assertThat(enumString, containsString("TYPE A"));

    }

    @Test
    public void testJsonRootValue() throws JsonProcessingException {

        MyBeanForRootValue myBeanForRootValue = new MyBeanForRootValue();
        myBeanForRootValue.setId(1);
        myBeanForRootValue.setName("Mr Bean");

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String result = mapper.writeValueAsString(myBeanForRootValue);
        System.out.println("this the test for JsonRootName: " + result);
        assertThat(result, containsString("myBean"));

    }

    @Test
    public void testJsonSerializa() throws JsonProcessingException {
        Event event = new Event();
        event.setName("test event");
        event.setEventDate(new Date());
        String result = new ObjectMapper().writeValueAsString(event);
        //可以看到 eventDate字段使用了自定义的序列化
        System.out.println("this is the test for JsonSerializa: " + result);
    }

}
