package com.hshc.relay.service;

import com.hshc.relay.BaseTest;
import com.hshc.relay.entity.riskcontrol.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * @author 钟林俊
 * @version V1.0 2017-05-12 10:14
 */
public class RiskControlServiceTest extends BaseTest {

    @Autowired
    private RiskControlService riskControlService;

    @Test
    public void testSaveCustomer(){
        Customer customer = new Customer();
        customer.setName("张三");
        customer.setMobile("13833883388");
        customer.setIdentityNo("110101190001011111");
        customer.setConsigneeAddress("啊十分士大夫撒地方");
        customer.setUuid(UUID.randomUUID().toString());

        int added = riskControlService.add(customer);
        Assert.assertEquals(added, 1);
    }
}
