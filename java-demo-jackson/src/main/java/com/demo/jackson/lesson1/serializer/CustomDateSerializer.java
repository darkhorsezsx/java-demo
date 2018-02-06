package com.demo.jackson.lesson1.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This is {@link CustomDateSerializer}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class CustomDateSerializer<T> extends StdSerializer<Date> {

    //SimpleDateFormat Pattern中哪些是非法的
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd %%da");

    public CustomDateSerializer() {
        this(null);
    }

    public CustomDateSerializer(Class<Date> t) {
        super(t);
    }

    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(sdf.format(date));
    }
}
