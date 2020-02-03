package top.aftery.user.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.aftery.common.entity.Result;
import top.aftery.common.entity.StatusCode;
/**
 * @ClassName [Table2]
 * @Description统一异常处理
 * @Author Aftery
 * @Date 2020/1/28 
 * @Version 1.0
 */
@ControllerAdvice
public class BaseExceptionHandler {
	
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();        
        return new Result(false, StatusCode.ERROR, "执行出错");
    }
}
