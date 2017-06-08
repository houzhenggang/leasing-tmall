package com.hshc.relay.service;

import com.hshc.relay.BaseTest;
import com.taobao.api.response.TmallCarLeaseReserveResponse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 钟林俊
 * @version V1.0 2017-06-08 16:11
 */
public class CarLeaseReserveServiceTest extends BaseTest {

    @Autowired
    private CarLeaseReserveService carLeaseReserveService;

    @Test
    public void testAdd(){
        TmallCarLeaseReserveResponse.Result result = new TmallCarLeaseReserveResponse.Result();
        result.setGmtCurrentTime(14969909135663L);
        result.setSuccess(false);
        result.setErrorCode("10000");
        result.setErrorMessage("错误信息");
        result.setMsgCode("10000");
        result.setMsgInfo("错误信息");
        carLeaseReserveService.add(result);
    }

}
