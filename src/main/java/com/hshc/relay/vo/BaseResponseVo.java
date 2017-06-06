package com.hshc.relay.vo;

import com.qimencloud.api.QimenCloudResponse;

/**
 * @author 钟林俊
 * @version V1.0 2017-05-06 11:05
 */
public class BaseResponseVo extends QimenCloudResponse{

    private boolean success;

    public BaseResponseVo(){}

    public BaseResponseVo(String message){
        this(true, message);
    }

    public BaseResponseVo(boolean success, String message){
        this.success = success;
        setMessage(message);
    }

    public static BaseResponseVo success(){
        return success("");
    }

    public static BaseResponseVo success(String message){
        return new BaseResponseVo(true, message);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
