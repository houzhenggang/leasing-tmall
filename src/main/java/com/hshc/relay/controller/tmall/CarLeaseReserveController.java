package com.hshc.relay.controller.tmall;


import com.taobao.api.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hshc.relay.annotation.QimenSignAuthentication;
import com.hshc.relay.controller.BaseController;
import com.hshc.relay.controller.erp.ScitemController;
import com.hshc.relay.service.CarLeaseReserveService;
import com.hshc.relay.vo.BaseResponseVo;
import com.taobao.api.request.TmallCarLeaseReserveRequest;
import com.taobao.api.response.TmallCarLeaseReserveResponse;
/**
 * 整车租车回传预约信息
 * @author 史珂 2017年5月9日14:00:43
 *
 */
@Controller
public class CarLeaseReserveController extends BaseController {

    @Autowired
    private CarLeaseReserveService clrService;
    
	@RequestMapping("/lease-reserve")
	@ResponseBody
	@QimenSignAuthentication
	public BaseResponseVo leaseReserve(TmallCarLeaseReserveRequest req) throws ApiException {
		logger.info("nic=" + req.getBuyerNick());

		//获取返回参数
		TmallCarLeaseReserveResponse rsp = clrService.leaseReserve(req);
		logger.info("getBody:" + JSON.toJSONString(rsp));

		//保存返回的数据
		clrService.add(rsp.getResult());

		return new BaseResponseVo(true,JSON.toJSONString(rsp));
	}
}
