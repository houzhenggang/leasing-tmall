package com.hshc.relay.controller.tmall;

import com.hshc.relay.annotation.QimenSignAuthentication;
import com.hshc.relay.controller.BaseController;
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
public class RiskControlController extends BaseController {

    @Autowired
    private RiskControlService riskControlService;

    @RequestMapping(value = "/customer")
    @ResponseBody
    @QimenSignAuthentication
    public BaseQimenResponseVo acceptCustomerInfo(Customer customer){
        riskControlService.add(customer);

        return BaseQimenResponseVo.success();
    }

}
