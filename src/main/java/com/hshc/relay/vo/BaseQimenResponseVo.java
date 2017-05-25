package com.hshc.relay.vo;

import com.qimencloud.api.QimenCloudResponse;

/**
 * @author 钟林俊
 * @version V1.0 2017-05-06 11:05
 */
public class BaseQimenResponseVo extends QimenCloudResponse{

    private String success;

    public BaseQimenResponseVo(){}

    public BaseQimenResponseVo(String message){
        this("true", message);
    }

    public BaseQimenResponseVo(String success, String message){
        this.success = success;
        setMessage(message);
    }

    public static BaseQimenResponseVo success(){
        return success("");
    }

    public static BaseQimenResponseVo success(String message){
        return new BaseQimenResponseVo("true", message);
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

}
