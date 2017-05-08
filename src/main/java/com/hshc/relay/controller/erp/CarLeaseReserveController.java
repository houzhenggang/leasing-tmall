package com.hshc.relay.controller.erp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hshc.relay.annotation.QimenSignAuthentication;
import com.hshc.relay.controller.BaseController;
import com.hshc.relay.vo.BaseQimenResponseVo;

/**
 * @author 史珂 2017年5月7日12:01:26
 */
@Controller
public class CarLeaseReserveController extends BaseController{

	private static final Logger LOGGER = LoggerFactory.getLogger(CarLeaseReserveController.class);
	
	@RequestMapping("/lease-reserve")
	@ResponseBody
	@QimenSignAuthentication
	public BaseQimenResponseVo carLease(@RequestParam("order_id") Integer orderId,
			                            @RequestParam("text") String text,
			                            @RequestParam("vin") String vin,
			                            @RequestParam("flag") Integer flag,
			                            @RequestParam("buyer_nick") String buyerNick){
		LOGGER.info("orderId:"+orderId);
		LOGGER.info("text:"+text);
		LOGGER.info("vin:"+vin);
		LOGGER.info("flag:"+flag);
		LOGGER.info("buyerNick:"+buyerNick);
		return null;
	}
}
