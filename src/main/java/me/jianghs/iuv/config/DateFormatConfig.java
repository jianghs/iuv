package me.jianghs.iuv.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @className: DateFormatConfig
 * @description:
 * @author: jianghs430
 * @createDate: 2021/1/5 17:42
 * @version: 1.0
 */
@JsonComponent
public class DateFormatConfig {

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 日期格式化
     */
    public static class DateJsonSerializer extends JsonSerializer<LocalDateTime> {
        @Override
        public void serialize(LocalDateTime date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(dtf.format(date));
        }
    }

//    /**
//     * 解析日期字符串
//     */
//    public static class DateJsonDeserializer extends JsonDeserializer<LocalDateTime> {
//        @Override
//        public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, ParseException {
//            try {
//                return dateFormat.parse(jsonParser.getText());
//            } catch (ParseException e) {
//                throw new RuntimeException(e);
//            }
//
//        }
//    }
}
