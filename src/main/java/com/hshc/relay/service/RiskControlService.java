package com.hshc.relay.service;

import com.hshc.relay.dao.CallbackLogDao;
import com.hshc.relay.entity.riskcontrol.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author 钟林俊
 * @version V1.0 2017-05-07 16:54
 */
@Service
public class RiskControlService extends BaseService<Customer> {

    @Autowired
    private CallbackLogDao callbackLogDao;

    @Async
    public void riskCallback(Integer id){
        try {
            TimeUnit.MINUTES.sleep(8L);
        } catch (InterruptedException ignored) {
        }


    }


}
