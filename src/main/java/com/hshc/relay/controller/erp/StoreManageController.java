package com.hshc.relay.controller.erp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hshc.relay.service.RequestTaobaoService;
import com.hshc.relay.vo.BaseQimenResponseVo;
import com.taobao.api.ApiException;
import com.taobao.api.request.InventoryStoreManageRequest;
import com.taobao.api.response.InventoryStoreManageResponse;

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
		
		
		//封装
		
		InventoryStoreManageRequest req = new InventoryStoreManageRequest();
		req.setOperateType("ADD");
		req.setStoreCode("HS000002");
		req.setStoreName("北京仓");
		req.setStoreType("TYPE_OWN");
		req.setAliasName("京");
		req.setAddress("东大街000号");
		req.setAddressAreaName("北京~北京市~崇文区");
		req.setContact("张三四");
		req.setPhone("13333333333");
		req.setPostcode(100000L);
		//调用
		InventoryStoreManageResponse res;
		try {
			res = (InventoryStoreManageResponse) RequestTaobaoService.requset(req);
			//res.getBody()返回值 json
			//结果存储对应表
			System.out.println(res.getBody());
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return new BaseQimenResponseVo("创建/更新成功");
	}

}
