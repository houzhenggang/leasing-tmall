package com.hshc.relay.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.hshc.relay.service.RequestTaobaoClientService;
import com.hshc.relay.service.StoreManageService;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.Store;
import com.taobao.api.request.InventoryStoreManageRequest;
import com.taobao.api.response.InventoryStoreManageResponse;

public class StoreManageServiceTest extends BaseTest{

	@Autowired
	private StoreManageService smService;
	@Autowired
	private AuthorizedSessionService asService;
	
	@Test
	public void testStoreManage(){
		InventoryStoreManageRequest req = new InventoryStoreManageRequest();
		req.setOperateType("ADD");
		req.setStoreCode("testck");
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
			TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest",asService.getAppKey(), asService.getAppSecret());
			rsp = client.execute(req, asService.getAuthorizedSession("花生好车旗舰店").getAccessToken());
			System.out.println("==========="+rsp.getBody());
			//res.getBody()返回值 json
			//结果存储对应表
			//StoreManage storeManage = (StoreManage) JSON.(rsp.getBody());
			Store store = rsp.getStoreList().get(0);
			System.out.println("==========="+store);
			if(req.getOperateType().equals("ADD")||req.getOperateType()=="ADD"){
				smService.addStoreList(store);
			}else if(req.getOperateType().equals("UPDATE")||req.getOperateType()=="UPDATE"){
				smService.upStoreList(store);
			}
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
