package com.demo.jackson.lesson1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is {@link SerializeFeaturesTest}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class SerializeFeaturesTest {

    /**
     *
     * SerializationFeature常用配置项
     *
     *
     WRAP_ROOT_VALUE(false),    是否环绕根元素输出
     INDENT_OUTPUT(false),     是否缩放排列输出，便于排版
     FAIL_ON_EMPTY_BEANS(true),
     FAIL_ON_SELF_REFERENCES(true),
     WRAP_EXCEPTIONS(true),
     FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS(true),
     CLOSE_CLOSEABLE(false),
     FLUSH_AFTER_WRITE_VALUE(true),
     WRITE_DATES_AS_TIMESTAMPS(true), 使用timestamp输出，默认true
     WRITE_DATE_KEYS_AS_TIMESTAMPS(false),
     WRITE_DATES_WITH_ZONE_ID(false),
     WRITE_DURATIONS_AS_TIMESTAMPS(true),
     WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS(false),       序列化char[]数组时，以Json数组输出
     WRITE_ENUMS_USING_TO_STRING(false),    序列化枚举类型使用toString输出，即默认以name()输出
     WRITE_ENUMS_USING_INDEX(false),    序列化枚举类型使用ordinal()输出，默认false
     WRITE_NULL_MAP_VALUES(true),

     @Deprecated
     WRITE_EMPTY_JSON_ARRAYS(true),
     WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED(false),     序列化单个元素的数组不以数组输出
     @Deprecated
     WRITE_BIGDECIMAL_AS_PLAIN(false),      序列化BigDecimal时，输出原始数字还是科学计数，即是否用toPlainString()为科学计数方式输出
     WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS(true),
     ORDER_MAP_ENTRIES_BY_KEYS(false),      序列化map时，对key进行排序
     EAGER_SERIALIZER_FETCH(true),
     USE_EQUALITY_FOR_OBJECT_ID(false);
     *
     */

    public static MyBean myBean = new MyBean();

    {
        myBean.setName("Jack");
        myBean.setPhone("18612341234");
        myBean.setAge(20);
        myBean.setJsonInfo("{\"value\": 23}");
    }

    @Before
    public void init() {
        System.out.println();
        System.out.println("#############################");
    }

    @Test
    public void testWrapRootValue() throws JsonProcessingException {
        ObjectMapper mapperDefault = new ObjectMapper();
        String resultDefault = mapperDefault.writeValueAsString(myBean);

        System.out.println("this is the test of testWrapRootValue:");
        System.out.println("default: " + resultDefault);


        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String result = mapper.writeValueAsString(myBean);
        System.out.println("WrapRootValue enabled: " + result);
        //可以配合 @JsonRootName("test") 进行Wrapper name值的设定，如果没有，则默认使用类名
    }

    @Test
    public void testIndentOutput() throws JsonProcessingException {

        ObjectMapper mapperDefault = new ObjectMapper();
        String resultDefault = mapperDefault.writeValueAsString(myBean);
        System.out.println("this is the test of testIndentOutput:");
        System.out.println("default: " + resultDefault);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String result = mapper.writeValueAsString(myBean);
        System.out.println("IndentOutput enabled: " + result);
    }

    @Test
    public void testFailOnEmptyBeans() throws JsonProcessingException {

        ObjectMapper mapperDefault = new ObjectMapper();
        String resultDefault = mapperDefault.writeValueAsString(null);
        System.out.println("this is the test of testFailOnEmptyBeans:");
        System.out.println("default: " + resultDefault);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        String result = mapper.writeValueAsString(myBean);
        System.out.println("IndentOutput enabled: " + result);
    }

    @After
    public void end() {
        System.out.println("#############################");
        System.out.println();
    }

}
