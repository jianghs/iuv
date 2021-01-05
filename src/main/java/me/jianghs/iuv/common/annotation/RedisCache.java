package me.jianghs.iuv.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author jianghs430
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisCache {
    /**
     * key
     * @return
     */
    String key();

    /**
     * 过期时间
     * @return
     */
    long timeOut() default 0;

    /**
     * 过期单位
     * @return
     */
    TimeUnit timeUnit() default TimeUnit.SECONDS;
}
