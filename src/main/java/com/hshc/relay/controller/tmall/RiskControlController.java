package com.hshc.relay.controller.tmall;

import com.hshc.relay.annotation.QimenSignAuthentication;
import com.hshc.relay.controller.BaseController;
import com.hshc.relay.entity.riskcontrol.Customer;
import com.hshc.relay.service.RiskControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 钟林俊
 * @version V1.0 2017-05-07 16:49
 */
@Controller
@RequestMapping("/risk-control")
public class RiskControlController extends BaseController {

    @Autowired
    private RiskControlService riskControlService;

    @RequestMapping(value = "/customer")
    @ResponseBody
    @QimenSignAuthentication
    public Map<String,Object> acceptCustomerInfo(@RequestBody Customer customer){
        Map<String, Object> ret = new HashMap<>();
        try{
            riskControlService.add(customer);
            ret.put("success", "true");
        }catch (Exception e){
            logger.error("", e);
            ret.put("success", "false");
            ret.put("sub_code", e.getClass().getSimpleName());
            ret.put("sub_message", e.getMessage());
        }

        return ret;
    }

}
