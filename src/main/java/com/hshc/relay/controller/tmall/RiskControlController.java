package com.hshc.relay.controller.tmall;

import com.alibaba.fastjson.JSON;
import com.hshc.relay.controller.QimenStreamController;
import com.hshc.relay.entity.riskcontrol.Customer;
import com.hshc.relay.service.RiskControlService;
import com.hshc.relay.vo.BaseQimenResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author 钟林俊
 * @version V1.0 2017-05-07 16:49
 */
@Controller
@RequestMapping("/risk-control")
public class RiskControlController extends QimenStreamController {

    @Autowired
    private RiskControlService riskControlService;

    @RequestMapping(value = "/customer")
    @ResponseBody
    public BaseQimenResponseVo acceptCustomerInfo(@ModelAttribute("requestBody") String requestBody){
        riskControlService.add(JSON.parseObject(requestBody, Customer.class));

        return BaseQimenResponseVo.success();
    }

}
