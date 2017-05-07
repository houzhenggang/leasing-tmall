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
	public BaseQimenResponseVo storeManager(@RequestParam("operate_type") String operateType,@RequestParam("store_code") String storeCode){
		LOGGER.info("operateType:"+operateType);
		LOGGER.info("storeCode:"+storeCode);
		return new BaseQimenResponseVo("创建/更新成功");
	}

}
