package com.demo.jackson.lesson5;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * This is {@link ObjectMapperTest}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class ObjectMapperTest {


    @Test
    public void testNamingStrategy() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
//        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        BeanForMapper person = new BeanForMapper(1, "张", "三", "somewhere");
        String resuitSnakeCase = mapper.writeValueAsString(person);
        System.out.printf("this is the test for NamingStrategy SNAKE_CASE:" + resuitSnakeCase);
    }

    @Test
    public void testObjectAsKeyInMay() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        BeanForMapper person1 = new BeanForMapper(1,"张", "三", "somewhere");
        BeanForMapper person2 = new BeanForMapper(2,"李", "四", "somewhere");
        Map<BeanForMapper, Integer> map = new HashMap<BeanForMapper, Integer>();
        map.put(person1, 2);
        map.put(person2, 10);
        String result = mapper.writeValueAsString(map);
        System.out.printf("this is the test for NamingStrategy SNAKE_CASE:" + result);

        BeanForMapper personKey = new BeanForMapper(1,"张", "三", "somewhere");
        Integer resultCount = map.get(personKey);
        System.out.println(resultCount);
    }

}
