package com.hshc.relay.controller.tmall;

import com.hshc.relay.annotation.QimenSignAuthentication;
import com.hshc.relay.controller.BaseController;
import com.hshc.relay.dto.PageRequest;
import com.hshc.relay.dto.qo.CustomerQo;
import com.hshc.relay.entity.riskcontrol.Customer;
import com.hshc.relay.service.RiskControlService;
import com.hshc.relay.vo.BaseResponseVo;
import com.hshc.relay.vo.PageVo;
import com.taobao.api.ApiException;
import com.taobao.api.response.TmallCarLeaseRiskcallbackResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

/**
 * @author 钟林俊
 * @version V1.0 2017-05-07 16:49
 */
@RestController
@RequestMapping("/risk-control")
public class RiskControlController extends BaseController {

    @Autowired
    private RiskControlService riskControlService;

    @RequestMapping(value = "/customer")
    @QimenSignAuthentication
    public BaseResponseVo acceptCustomerInfo(Customer customer, @RequestParam("identity_no") String identityNo, @RequestParam("item_id") long itemId) throws ApiException, InterruptedException {
        customer.setIdentityNo(identityNo);
        customer.setItemId(itemId);
        riskControlService.add(customer);
        riskControlService.sendRiskControlResult(customer.getUuid());
        return BaseResponseVo.success();
    }

    @RequestMapping(value = "/return-top/{uuid}", method = RequestMethod.POST)
    public TmallCarLeaseRiskcallbackResponse.Result sendRiskControlResult(@PathVariable String uuid) throws ApiException, InterruptedException, ExecutionException {
        return riskControlService.sendRiskControlResult(uuid).get();
    }

    @RequestMapping(value = "/customers")
    public PageVo getCustomers(@RequestBody PageRequest<CustomerQo> pageRequest){
        return PageVo.success(riskControlService.getPage(pageRequest));
    }

}
