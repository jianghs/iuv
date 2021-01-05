package me.jianghs.iuv.common.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.jianghs.iuv.common.annotation.RedisCache;
import me.jianghs.iuv.common.cache.redis.RedisUtil;
import me.jianghs.iuv.common.enums.ResultCode;
import me.jianghs.iuv.common.exception.BaseException;
import me.jianghs.iuv.entity.Tag;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @className: RedisCacheAop
 * @description:
 * @author: jianghs430
 * @createDate: 2021/1/5 16:39
 * @version: 1.0
 */
@Component
@Aspect
public class RedisCacheAop {
    @Resource
    private RedisUtil redisUtil;

    @Around("@annotation(redisCache)")
    public Object around(ProceedingJoinPoint joinPoint, RedisCache redisCache) {
        try {
            // 目标方法执行的返回结果
            Object result;
            //1.动态获取注解中的数据
            String preKey = redisCache.key();
            //2.动态获取方法中的参数  将数组转化为字符串
            String args = Arrays.toString(joinPoint.getArgs());
            String key = preKey + "::" + args;
            if (redisUtil.hasKey(key)) {
                result = redisUtil.get(key);
            } else {
                result = joinPoint.proceed();
                if (Objects.nonNull(result)) {
                    if (redisCache.timeOut() > 0) {
                        redisUtil.set(key, result, redisCache.timeOut(), redisCache.timeUnit());
                    } else {
                        redisUtil.set(key, result);
                    }
                }
            }
            return result;
        } catch (Throwable throwable) {
            throw new BaseException(ResultCode.FAILED, "缓存处理失败");
        }
    }
}
