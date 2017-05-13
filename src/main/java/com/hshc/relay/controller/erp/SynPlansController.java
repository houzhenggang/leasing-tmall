package com.hshc.relay.controller.erp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
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

import java.util.List;

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
    public TmallCarLeaseSynchronizeplansResponse sysPlans(TmallCarLeaseSynchronizeplansRequest reqSyn)throws ApiException{
          System.out.println("同步租赁方案信息-项目编号："+reqSyn.getItemId());
        System.out.println("同步租赁方案信息-方案信息："+reqSyn.getPlans());
        List<TmallCarLeaseSynchronizeplansRequest.CarLeasePlanDo> plans = JSON.parseArray(reqSyn.getPlans(), TmallCarLeaseSynchronizeplansRequest.CarLeasePlanDo.class);
        reqSyn.setPlans(plans);
        System.out.println("同步租赁方案信息-公司名称："+plans.get(0).getCompanyName());
        return  synPlansService.sysPlans(reqSyn);
    }

}
