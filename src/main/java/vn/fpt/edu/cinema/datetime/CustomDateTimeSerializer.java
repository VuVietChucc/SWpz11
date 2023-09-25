package vn.fpt.edu.cinema.datetime;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDateTime;

import static vn.fpt.edu.cinema.utils.CustomDateTimeFormatter.DATE_TIME_HORO;

/**
 * vn.fpt.edu.cinema.datetime
 *
 * @author : Portgas.D.Ace
 * @created : 21/05/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/

public class CustomDateTimeSerializer extends StdSerializer<LocalDateTime> {

    public CustomDateTimeSerializer(){
        this(null);
    }

    public CustomDateTimeSerializer(Class<LocalDateTime> t) {
        super(t);
    }

    @Override
    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

//        jsonGenerator.writeString(localDateTime.format(DATE_TIME_FORMATTER));
//        jsonGenerator.writeString(localDateTime.format(DATE_FORMATTER));
        jsonGenerator.writeString(localDateTime.format(DATE_TIME_HORO));

    }
}
