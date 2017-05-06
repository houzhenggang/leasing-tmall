package com.hshc.relay.controller;

import com.hshc.relay.exception.BaseException;
import com.hshc.relay.vo.BaseResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
public abstract class BaseController
{
    protected static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResponseVo errorResponse(Exception e, HttpServletResponse response) {
        logger.error("", e);
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        BaseResponseVo responseVo = new BaseResponseVo();
        String code = "400";
        String message = e.getMessage();
        if(e instanceof BindException){
            BindException bindException = (BindException) e;
            BindingResult bindingResult = bindException.getBindingResult();
            if(bindingResult.hasErrors()){
                message = "验证失败：";
                for(FieldError fieldError : bindingResult.getFieldErrors()){
                    message += fieldError.getDefaultMessage() + " ";
                }
            }
            code = "412";
        } else if (e instanceof BaseException) {
            BaseException baseException = (BaseException) e;
            responseVo.setCode(baseException.getCode());
            message = e.getMessage();
            if (baseException.getAttrs() != null) {
                responseVo.setAttrs(baseException.getAttrs());
            }
        }
        responseVo.setCode(code);
        responseVo.setMessage(message);
        return responseVo;
    }

}
