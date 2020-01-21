package top.aftery.base.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.aftery.common.entity.Result;
import top.aftery.common.entity.StatusCode;

/**
 * @ClassName BaseExceptionHandler
 * @Description BaseExceptionHandler
 * @Author Aftery
 * @Date 2020/1/20 14:43
 * @Version 1.0
 */
@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result error(Exception e) {
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR, e.getMessage());
    }
}
