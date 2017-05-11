package com.hshc.relay.controller.tmall;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hshc.relay.controller.BaseController;
import com.hshc.relay.controller.erp.StoreManageController;
import com.hshc.relay.service.CarLeaseTailpaymentbackService;
import com.hshc.relay.vo.BaseQimenResponseVo;
import com.taobao.api.request.TmallCarLeaseTailpaymentbackRequest.TailPaymentDto;
import com.taobao.api.response.TmallCarLeaseTailpaymentbackResponse;
/**
 * 尾款处置方案回传
 * @author 史珂
 * 2017年5月10日下午2:58:40
 */
@Controller
public class CarLeaseTailpaymentbackController extends BaseController {

	public static final Logger LOGGER = LoggerFactory.getLogger(StoreManageController.class); 

	@Autowired
	private CarLeaseTailpaymentbackService cltService;
	
	@RequestMapping("/lease-tailpaymentback")
	@ResponseBody
	//@QimenSignAuthentication
	public BaseQimenResponseVo leaseTailpaymentback(@RequestBody String res){
		try {
			TailPaymentDto tailPaymentDto = JSON.parseObject(res,TailPaymentDto.class);
			//获取返回值
			TmallCarLeaseTailpaymentbackResponse leaseTailpaymentback = cltService.leaseTailpaymentback(tailPaymentDto);
			LOGGER.info("leaseTailpaymentback:"+leaseTailpaymentback.getBody());
			//保存返回的信息
			cltService.addleaseTailpaymentback(leaseTailpaymentback.getResult());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new BaseQimenResponseVo("尾款处置方案回传成功");
	}
}
