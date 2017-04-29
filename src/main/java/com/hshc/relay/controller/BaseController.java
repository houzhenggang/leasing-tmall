package com.hshc.relay.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hshc.relay.exception.BaseException;
import com.hshc.relay.vo.BaseResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

import static org.apache.http.HttpStatus.SC_FORBIDDEN;

@Controller
public abstract class BaseController
{
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String errorResponse(Exception e, HttpServletResponse response) {
        logger.error("", e);
        response.setStatus(SC_FORBIDDEN);
        BaseResponseVo responseVo = new BaseResponseVo();
        responseVo.setCode("400");
        String message = "请求失败,请稍后重试";
        if (e instanceof BaseException) {
            BaseException baseException = (BaseException) e;
            responseVo.setCode(baseException.getCode());
            message = e.getMessage();
            if (baseException.getAttrs() != null) {
                responseVo.setAttrs(baseException.getAttrs());
            }
        }
        responseVo.setMessage(message);
        return JSON.toJSONStringWithDateFormat(responseVo, "yyyy-MM-dd HH:mm:ss", SerializerFeature.DisableCircularReferenceDetect);
    }

    protected ResponseEntity<String> response(Object resp) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        String json = JSON.toJSONStringWithDateFormat(resp, "yyyy-MM-dd HH:mm:ss", SerializerFeature.DisableCircularReferenceDetect);
        return new ResponseEntity<>(json, headers, HttpStatus.OK);
    }

}
