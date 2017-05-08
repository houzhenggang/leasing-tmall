package com.hshc.relay.service1.tmallTest;

import com.hshc.relay.service.RequestTaobaoService;
import com.taobao.api.ApiException;
import com.taobao.api.request.InventoryStoreQueryRequest;
import com.taobao.api.response.InventoryStoreQueryResponse;

public class 获取仓库信息列表 {


	public static void main(String[] args) {
		
//		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
//		TmallInventoryQueryForstoreRequest req = new TmallInventoryQueryForstoreRequest();
//		List<InventoryQueryForStoreRequest> list2 = new ArrayList<InventoryQueryForStoreRequest>();
//		InventoryQueryForStoreRequest obj3 = new InventoryQueryForStoreRequest();
//		list2.add(obj3);
//		//obj3.setScItemCode("1001");
//		//obj3.setStoreCode("D25");
//		//obj3.setScItemId(123L);
//		//obj3.setInvStoreType(6L);
//		req.setParamList(list2);
//		
//		TmallInventoryQueryForstoreResponse rsp;
//		try {
//			rsp = client.execute(req, sessionKey);
//			System.out.println(rsp.getBody());
//		} catch (ApiException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		queryCK("HS000001");
	}
	
	public static void queryCK(String ck){
		InventoryStoreQueryRequest req = new InventoryStoreQueryRequest();
		//req.setStoreCode(ck);
		InventoryStoreQueryResponse rsp;
		try {
			rsp = (InventoryStoreQueryResponse) RequestTaobaoService.requset(req);
			System.out.println(rsp.getBody());
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
