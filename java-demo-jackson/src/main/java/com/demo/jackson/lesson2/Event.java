package com.demo.jackson.lesson2;

import com.demo.jackson.lesson2.deserializer.CustomDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;

/**
 * This is {@link Event}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class Event {

    public String name;

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public Date eventDate;

}
