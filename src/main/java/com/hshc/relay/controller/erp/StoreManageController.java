package com.hshc.relay.controller.erp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hshc.relay.vo.BaseQimenResponseVo;

/**
 * 
 * @author 史珂 2017年5月7日09:56:18
 *
 */
@Controller
public class StoreManageController {

	public static final Logger LOGGER = LoggerFactory.getLogger(StoreManageController.class); 

	@RequestMapping("/lease-store")
	@ResponseBody
	public BaseQimenResponseVo storeManager(@RequestParam("operate_type") String operateType,
			                                @RequestParam("store_code") String storeCode,
			                                @RequestParam("store_name") String storeName,
			                                @RequestParam("store_type") String storeType,
			                                @RequestParam("address") String address,
			                                @RequestParam("address_area_name") String addressAreaName){
		LOGGER.info("operateType:"+operateType);
		LOGGER.info("storeCode:"+storeCode);
		LOGGER.info("storeName:"+storeName);
		LOGGER.info("storeType:"+storeType);
		LOGGER.info("address:"+address);
		LOGGER.info("addressAreaName:"+addressAreaName);
		return new BaseQimenResponseVo("创建/更新成功");
	}

}
