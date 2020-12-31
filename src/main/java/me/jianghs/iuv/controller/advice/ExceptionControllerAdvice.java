package me.jianghs.iuv.controller.advice;

import lombok.extern.slf4j.Slf4j;
import me.jianghs.iuv.common.enums.ResultCode;
import me.jianghs.iuv.common.exception.BaseException;
import me.jianghs.iuv.common.result.Result;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @className: ExceptionControllerAdvice
 * @description:
 * @author: jianghs430
 * @createDate: 2020/12/31 17:04
 * @version: 1.0
 */
@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        log.error(objectError.getDefaultMessage());
        return new Result<>(ResultCode.VALIDATE_FAILED, objectError.getDefaultMessage());
    }

    @ExceptionHandler(BaseException.class)
    public Result<String> BaseExceptionHandler(BaseException e) {
        log.error(e.getMsg());
        return new Result<>(ResultCode.FAILED, e.getMsg());
    }
}
