package com.hshc.relay.controller.erp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hshc.relay.controller.BaseController;
import com.hshc.relay.service.InventoryMerchantAdjustService;
import com.hshc.relay.vo.BaseQimenResponseVo;
import com.taobao.api.request.InventoryMerchantAdjustRequest;
import com.taobao.api.request.InventoryMerchantAdjustRequest.InventoryCheckDetailDto;
import com.taobao.api.request.InventoryMerchantAdjustRequest.InventoryCheckDto;
import com.taobao.api.response.InventoryMerchantAdjustResponse;
/**
 * taobao.inventory.merchant.adjust (货品库存商家端调整)
 * @author 吴国伟
 *
 */
@Controller
public class InventoryMerchantAdjustController extends BaseController{

	private Logger logger =Logger.getLogger(InventoryMerchantAdjustController.class);
	@Autowired
	private InventoryMerchantAdjustService inventoryMerchantAdjustService;
	
	
	@RequestMapping("/merchant-adjust")
	@ResponseBody
	public BaseQimenResponseVo inventoryMerchantAdjust(InventoryMerchantAdjustRequest inventoryMerchantAdjustRequest){
		//获取JSON
//		System.out.println("res========"+res);
//		List<Object> list = JSON.parseArray(JSON.parseObject(res).get("data").toString());
		InventoryMerchantAdjustResponse rsp = new InventoryMerchantAdjustResponse();
		try {
			//数据封装
//			InventoryMerchantAdjustRequest inventoryMerchantAdjustRequest = new InventoryMerchantAdjustRequest();
//			logger.info("=="+list);
//			InventoryCheckDto ic = new InventoryCheckDto();
//			ic.setCheckMode(2L);
//			ic.setInvStoreType(2L);
//			
//			List<InventoryCheckDetailDto> listc_inc = new ArrayList<InventoryCheckDetailDto>();
//			Map<String,Object>  m;
//			
//			for(Object o:list){
//				m = (Map<String,Object>)o;
//				InventoryCheckDetailDto obj4 = new InventoryCheckDetailDto();
//				//obj4.setInvBizCode("ONLINE_INVENTORY");
//				obj4.setQuantity(Long.valueOf(m.get("QUANTITY").toString()));
//				obj4.setScItemId(Long.valueOf(m.get("SC_ITEM_ID").toString()));
//				obj4.setSubOrderId("hshc_checksub"+m.get("SC_ITEM_ID")+"_"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
//				listc_inc.add(obj4);
//			}
//			
//			
//			ic.setStoreCode("testck");
//			ic.setOrderId("hshc_checkmain"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
//			ic.setDetailList(listc_inc);
//			inventoryMerchantAdjustRequest.setInventoryCheck(ic);
			//发送天猫
		   rsp = inventoryMerchantAdjustService.InventoryMerchantAdjust(inventoryMerchantAdjustRequest);
		   
		} catch (Exception e) {
			new BaseQimenResponseVo("更新失败");
		}
		return new BaseQimenResponseVo("更新成功");
	}
}
