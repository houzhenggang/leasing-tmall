package com.hshc.relay.service.erpTest;

import com.hshc.relay.service.SynPlansService;
import com.taobao.api.ApiException;
import com.taobao.api.request.TmallCarLeaseSynchronizeplansRequest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wanghuaying on 2017/5/10.
 */
public class SynPlansServiceTest {

    @Autowired
    private SynPlansService synPlansService;

    @Test
    public void testSysPlans() throws ApiException{
        TmallCarLeaseSynchronizeplansRequest reqSyn=new TmallCarLeaseSynchronizeplansRequest();
        synPlansService.sysPlans(reqSyn);
    }

}
