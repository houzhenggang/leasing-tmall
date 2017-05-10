package com.hshc.relay.controller.tmall;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hshc.relay.annotation.QimenSignAuthentication;
import com.hshc.relay.controller.BaseController;
import com.hshc.relay.controller.erp.StoreManageController;
import com.hshc.relay.service.CarLeaseConsumeService;
import com.hshc.relay.vo.BaseQimenResponseVo;
import com.taobao.api.request.TmallCarLeaseConsumeRequest.CosumeCodeReqDto;
import com.taobao.api.response.TmallCarLeaseConsumeResponse;
/**
 * 汽车租赁核销
 * @author 史珂
 * 2017年5月10日上午00:07:45
 */
@Controller
public class CarLeaseConsumeController extends BaseController {

	public static final Logger LOGGER = LoggerFactory.getLogger(StoreManageController.class); 
	
	@Autowired
	CarLeaseConsumeService clcService;
	
	
	@RequestMapping("/lease-consume")
	@ResponseBody
	@QimenSignAuthentication
	public BaseQimenResponseVo leaseConsume(@Valid CosumeCodeReqDto cosumeCodeReqDto){
		try {
			//获取返回参数
			TmallCarLeaseConsumeResponse leaseConsume = clcService.leaseConsume(cosumeCodeReqDto);
			LOGGER.info("leaseConsume:"+leaseConsume.getBody());
		    //保存核销返回信息
			clcService.addleaseConsume(leaseConsume.getResult());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new BaseQimenResponseVo("汽车租赁核销成功");
	}
}
