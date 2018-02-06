package com.demo.jackson.lesson4;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This is {@link Zoo}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
@Data
@AllArgsConstructor
public class Zoo {

    /**
     * @JsonTypeInfo 在序列化时被用来决定
     * @JsonSubTypes 被用来指明子类的类型
     * @JsonTypeName
     */

    public Animal animal;

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Dog.class, name = "dog"),
            @JsonSubTypes.Type(value = Cat.class, name = "cat")
    })

    public static class Animal {
        public String name;

        public Animal() {

        }

        public Animal(String name) {
            this.name = name;
        }
    }

    @JsonTypeName("dog")
    @AllArgsConstructor
    public static class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }
        public double barkVolume;
    }

    @JsonTypeName("cat")
    @AllArgsConstructor
    public static class Cat extends Animal {
        boolean likesCream;
        public int lives;
    }

}
