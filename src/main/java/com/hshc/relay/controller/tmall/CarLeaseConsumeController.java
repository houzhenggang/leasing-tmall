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
import com.hshc.relay.controller.erp.StoreManageController;
import com.hshc.relay.service.CarLeaseConsumeService;
import com.hshc.relay.vo.BaseResponseVo;
import com.taobao.api.request.TmallCarLeaseConsumeRequest;
import com.taobao.api.response.TmallCarLeaseConsumeResponse;
/**
 * 汽车租赁核销
 * @author 史珂
 * 2017年5月10日上午00:07:45
 */
@Controller
public class CarLeaseConsumeController extends BaseController {

	@Autowired
	private CarLeaseConsumeService clcService;

	@RequestMapping("/lease-consume")
	@ResponseBody
	@QimenSignAuthentication
	public BaseResponseVo leaseConsume(TmallCarLeaseConsumeRequest res) throws ApiException {
		logger.info("111:" + res.getCosumeCodeReqDTO());

		//获取返回参数
		TmallCarLeaseConsumeResponse rsp = clcService.leaseConsume(res);
		logger.info("leaseConsume:" + rsp.getBody());

		//保存核销返回信息
	    if(rsp.isSuccess()){
			clcService.add(rsp.getResult());
		}
		
		return 	new BaseResponseVo(rsp.isSuccess(),JSON.toJSONString(rsp.getBody()));
	}
}
