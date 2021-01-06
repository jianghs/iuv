package me.jianghs.iuv.config.swagger;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @className: Knife4jProperties
 * @description:
 * @author: jianghs430
 * @createDate: 2021/1/6 16:21
 * @version: 1.0
 */
@Component
@Data
public class Knife4jProperties {
    /**
     * 是否开启swagger，生产环境一般关闭，所以这里定义一个变量
     */
    @Value("${knife4j-swagger.enable}")
    private Boolean enable;

    /**
     * 项目应用名
     */
    @Value("${knife4j-swagger.application-name}")
    private String applicationName;

    /**
     * 项目版本信息
     */
    @Value("${knife4j-swagger.application-version}")
    private String applicationVersion;

    /**
     * 项目描述信息
     */
    @Value("${knife4j-swagger.application-description}")
    private String applicationDescription;

    /**
     * 接口调试地址
     */
    @Value("${knife4j-swagger.try-host}")
    private String tryHost;

}
