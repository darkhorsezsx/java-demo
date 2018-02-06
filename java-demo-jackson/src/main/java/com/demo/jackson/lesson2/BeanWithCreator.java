package com.demo.jackson.lesson2;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This is {@link BeanWithCreator}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class BeanWithCreator {

    public int id;
    public String name;

    public BeanWithCreator() {

    }

    //@JsonCreator主要用户反序列化，借助类的构造函数，将某些特定的命名的属性与真实属性关联，并设置值,
    //例如 json中属性名为 theName，而真实属性名为 name，则可以通过这种注解将 theName 映射为 name
    //需要注意的是，虽然有Jackson的注解，但是确算是 BeanWithCreator 的一个全参构造函数
    @JsonCreator
    public BeanWithCreator(
            @JsonProperty("id") int id,
            @JsonProperty("theName") String name) {
        this.id = id;
        this.name = name;

        // TODO: 2017/12/6 @JsonProperty 只能在Deserialization时候绑定key吗？序列化时候是否也可以指定与属性名不同的key?
    }


}
