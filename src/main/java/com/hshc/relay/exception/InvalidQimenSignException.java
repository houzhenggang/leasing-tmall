package com.hshc.relay.exception;

/**
 * @author 钟林俊
 * @version V1.0 2017-05-07 11:56
 */
public class InvalidQimenSignException extends BaseException {

    public InvalidQimenSignException(){
        this("440", "奇门签名验证失败！");
    }

    private InvalidQimenSignException(String code, String message) {
        super(code, message);
    }
}
