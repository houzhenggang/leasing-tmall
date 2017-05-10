package com.hshc.relay.controller.tmall;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hshc.relay.annotation.QimenSignAuthentication;
import com.hshc.relay.controller.BaseController;
import com.hshc.relay.service.CarLeaseConsumeService;
import com.hshc.relay.vo.BaseQimenResponseVo;
import com.taobao.api.request.TmallCarLeaseConsumeRequest;
import com.taobao.api.request.TmallCarLeaseConsumeRequest.CosumeCodeReqDto;
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
	@QimenSignAuthentication
	public BaseQimenResponseVo leaseConsume(@Valid CosumeCodeReqDto cosumeCodeReqDto){
		try {
			//获取返回参数
			clcService.leaseConsume(cosumeCodeReqDto);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
