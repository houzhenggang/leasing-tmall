package com.hshc.relay.controller.erp;

import com.taobao.api.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hshc.relay.annotation.QimenSignAuthentication;
import com.hshc.relay.controller.BaseController;
import com.hshc.relay.service.InventoryMerchantAdjustService;
import com.hshc.relay.vo.BaseResponseVo;
import com.taobao.api.request.InventoryMerchantAdjustRequest;
import com.taobao.api.response.InventoryMerchantAdjustResponse;

/**
 * taobao.inventory.merchant.adjust (货品库存商家端调整)
 * @author 吴国伟
 *
 */
@Controller
public class InventoryMerchantAdjustController extends BaseController{

	@Autowired
	private InventoryMerchantAdjustService inventoryMerchantAdjustService;
	
	@RequestMapping("/merchant-adjust")
	@ResponseBody
	@QimenSignAuthentication
	public BaseResponseVo inventoryMerchantAdjust(InventoryMerchantAdjustRequest inventoryMerchantAdjustRequest) throws ApiException {
		InventoryMerchantAdjustResponse rsp = inventoryMerchantAdjustService.InventoryMerchantAdjust(inventoryMerchantAdjustRequest);
	   logger.info("body=" + JSON.toJSONString(rsp));

		return new BaseResponseVo(true,JSON.toJSONString(rsp));
	}
}
