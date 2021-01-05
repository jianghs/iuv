package me.jianghs.iuv.common.log;

import ch.qos.logback.classic.pattern.MessageConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.jianghs.iuv.common.enums.ResultCode;
import me.jianghs.iuv.common.exception.BaseException;
import org.slf4j.helpers.MessageFormatter;

import java.util.stream.Stream;

/**
 * @className: ArgumentJsonFormatLayout
 * @description:
 * @author: jianghs430
 * @createDate: 2021/1/5 10:21
 * @version: 1.0
 */
public class ArgumentJsonFormatLayout extends MessageConverter {
    @Override
    public String convert(ILoggingEvent event) {
        try {
            return MessageFormatter.arrayFormat(event.getMessage(), Stream.of(event.getArgumentArray())
                    .map(argument -> {
                        Class<?> aClass = argument.getClass();
                        if (aClass.equals(String.class)) {
                            // 如果是字符串则直接输出
                            return argument;
                        }
                        ObjectMapper om = new ObjectMapper();
                        try {
                            // 美化输出
//                            return om.writerWithDefaultPrettyPrinter().writeValueAsString(argument);
                            // 正常输出
                            return om.writeValueAsString(argument);
                        } catch (JsonProcessingException e) {
                            throw new BaseException(ResultCode.PARAM_CONVERT_FAILED, "json格式化失败");
                        }
                    }).toArray()).getMessage();
        } catch (Exception e) {
            return event.getMessage();
        }
    }
}
