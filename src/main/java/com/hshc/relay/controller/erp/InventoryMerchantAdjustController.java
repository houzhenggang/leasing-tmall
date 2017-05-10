package com.hshc.relay.controller.erp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hshc.relay.controller.BaseController;
import com.hshc.relay.service.InventoryMerchantAdjustService;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.InventoryMerchantAdjustRequest;
import com.taobao.api.request.InventoryMerchantAdjustRequest.InventoryCheckDetailDto;
import com.taobao.api.request.InventoryMerchantAdjustRequest.InventoryCheckDto;
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
	public Map<String,Object> inventoryMerchantAdjust(@RequestParam("sc_item_id")String sc_item_id,@RequestParam("quantity")String quantity)throws ApiException{
		
		InventoryMerchantAdjustRequest inventoryMerchantAdjustRequest = new InventoryMerchantAdjustRequest();
		InventoryCheckDto obj1 = new InventoryCheckDto();
		obj1.setCheckMode(2L);
		obj1.setInvStoreType(2L);
		List<InventoryCheckDetailDto> listc_inc = new ArrayList<InventoryCheckDetailDto>();
		InventoryCheckDetailDto obj4 = new InventoryCheckDetailDto();
		//obj4.setInvBizCode("ONLINE_INVENTORY");
		obj4.setQuantity(Long.valueOf(quantity));
		obj4.setScItemId(Long.valueOf(sc_item_id));
		obj4.setSubOrderId("hshc_checksub"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		obj1.setStoreCode("testck");
		obj1.setOrderId("hshc_checkmain"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		listc_inc.add(obj4);
		obj1.setDetailList(listc_inc);
		inventoryMerchantAdjustRequest.setInventoryCheck(obj1);
		inventoryMerchantAdjustService.InventoryMerchantAdjust(inventoryMerchantAdjustRequest);
		return null;
	}
}
