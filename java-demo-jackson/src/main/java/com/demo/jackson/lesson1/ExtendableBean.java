package com.demo.jackson.lesson1;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * This is {@link ExtendableBean}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class ExtendableBean {

    private String name;

    //这里需要注意如果自动new 出HashMap,在测试JsonAnySetter会出错
    private Map<String, Object> properties = new HashMap<String, Object>();

    //@JsonAnySetter 反序列化时起作用，将属性生成map
    @JsonAnySetter
    public void add(String key, Object value) {
        properties.put(key, value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    //@JsonAnyGetter 序列化时起作用 可以将map内的属性序列化为实体的属性
    @JsonAnyGetter
    public Map<String, Object> getProperties() {
        return properties;
    }

    @JsonGetter("name")
    public String getCustomName() {
        return this.name + " customed";
    }
}
