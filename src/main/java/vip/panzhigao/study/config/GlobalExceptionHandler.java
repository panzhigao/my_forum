package vip.panzhigao.study.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import vip.panzhigao.study.exception.BusinessException;
import vip.panzhigao.study.vo.Response;

/**
 * @author panzhigao
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response<String> myExceptionErrorHandler(Exception ex) throws Exception {
        if(ex instanceof BusinessException){
            log.error("BusinessException error:{}",ex.getMessage());
            return Response.fail(ex.getMessage());
        }
        log.error("Exception error:{}",ex);
        return Response.fail();
    }

}
