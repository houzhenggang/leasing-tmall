package com.hshc.relay.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.hshc.relay.service.RequestTaobaoClientService;
import com.hshc.relay.service.StoreManageService;
import com.taobao.api.ApiException;
import com.taobao.api.domain.Store;
import com.taobao.api.request.InventoryStoreManageRequest;
import com.taobao.api.response.InventoryStoreManageResponse;

public class StoreManageServiceTest extends BaseTest{

	@Autowired
	private StoreManageService smService;
	
	@Test
	public void testStoreManage(){
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
		InventoryStoreManageResponse rsp;
		try {
			rsp = (InventoryStoreManageResponse) RequestTaobaoClientService.requset(req);
			System.out.println("==========="+rsp.getBody());
			//res.getBody()返回值 json
			//结果存储对应表
			InventoryStoreManageResponse storeManageResponse=JSON.parseObject(rsp.getBody(), InventoryStoreManageResponse.class, Feature.UseBigDecimal);
			Store storeManage = storeManageResponse.getStoreList().get(0);
			//StoreManage storeManage = (StoreManage) JSON.(rsp.getBody());
			System.out.println("==========="+storeManage);
			if(req.getOperateType().equals("ADD")||req.getOperateType()=="ADD"){
				smService.addStoreList(storeManage);
			}else if(req.getOperateType().equals("UPDATE")||req.getOperateType()=="UPDATE"){
				smService.upStoreList(storeManage);
			}
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
