package com.demo.webservice.exceptionhandler;

import com.demo.webservice.common.Response;
import com.demo.webservice.consts.StatusCode;
import com.demo.webservice.exception.DataNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response exceptionHandle(Exception e){
        // printLog()
        Response resp = new Response();
        resp.setStatusCode(StatusCode.SYSTEM_ERROR.getCode());
        resp.setMessage(StatusCode.SYSTEM_ERROR.getMsg());
        return resp;
    }

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseBody
    public Response dataNotFoundExceptionHandle(Exception e){
        // printLog()
        Response resp = new Response();
        resp.setStatusCode(StatusCode.DATA_NOT_FOUND.getCode());
        resp.setMessage(e.getMessage());
        return resp;
    }
}
