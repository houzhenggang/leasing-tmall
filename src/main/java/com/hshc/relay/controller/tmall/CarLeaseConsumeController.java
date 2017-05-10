package com.hshc.relay.controller.tmall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hshc.relay.controller.BaseController;
import com.hshc.relay.service.CarLeaseConsumeService;
import com.hshc.relay.vo.BaseQimenResponseVo;
import com.taobao.api.request.TmallCarLeaseConsumeRequest;
/**
 * 汽车租赁核销
 * @author 史珂
 * 2017年5月10日上午00:07:45
 */
@Controller
public class CarLeaseConsumeController extends BaseController {

	@Autowired
	CarLeaseConsumeService clcService;
	@RequestMapping("/lease-consume")
	@ResponseBody
	public BaseQimenResponseVo leaseConsume(){
		
		TmallCarLeaseConsumeRequest req = new TmallCarLeaseConsumeRequest();
		return null;
	}
}
