package me.jianghs.iuv;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author jianghs430
 */
@SpringBootApplication
@MapperScan(basePackages = "me.jianghs.iuv.mapper")
@EnableCaching
public class IuvApplication {

    public static void main(String[] args) {
        SpringApplication.run(IuvApplication.class, args);
    }

}
