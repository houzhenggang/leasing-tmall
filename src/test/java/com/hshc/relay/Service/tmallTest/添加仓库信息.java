package com.hshc.relay.service.tmallTest;


import com.hshc.relay.service.RequestTaobaoService;
import com.taobao.api.ApiException;
import com.taobao.api.request.InventoryStoreManageRequest;
import com.taobao.api.response.InventoryStoreManageResponse;

public class 添加仓库信息  {
	public  static void main(String[] agrs) {
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
			rsp = (InventoryStoreManageResponse) RequestTaobaoService.requset(req);
			System.out.println(rsp.getBody());
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
