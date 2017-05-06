package com.hshc.relay.vo;

/**
 * @author 钟林俊
 * @version V1.0 2017-05-06 11:05
 */
public class BaseQimenResponseVo {

    private boolean success;

    private String message;

    public BaseQimenResponseVo(String message){
        this(true, message);
    }

    public BaseQimenResponseVo(boolean success, String message){
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
