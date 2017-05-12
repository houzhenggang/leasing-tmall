package com.hshc.relay.controller.erp;

import com.hshc.relay.annotation.QimenSignAuthentication;
import com.hshc.relay.controller.BaseController;
import com.hshc.relay.service.SynPlansService;
import com.taobao.api.ApiException;
import com.taobao.api.request.TmallCarLeaseSynchronizeplansRequest;
import com.taobao.api.response.TmallCarLeaseSynchronizeplansResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 同步租赁方案信息
 * @author 王华英
 * @version V1.0 2017年5月6日16:54:25
 */
@Controller
public class SynPlansController extends BaseController{

    @Autowired
    private SynPlansService synPlansService;

    //同步租赁方案信息
    @RequestMapping("/lease-sysplans")
    @ResponseBody
    @QimenSignAuthentication
    public TmallCarLeaseSynchronizeplansResponse sysPlans(@RequestBody TmallCarLeaseSynchronizeplansRequest reqSyn)throws ApiException{
          return  synPlansService.sysPlans(reqSyn);
    }

}
