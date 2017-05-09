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
import com.taobao.api.request.TmallCarLeaseReserveRequest;
import com.taobao.api.response.InventoryStoreManageResponse;
import com.taobao.api.response.TmallCarLeaseReserveResponse;
import com.taobao.api.response.TmallCarLeaseReserveResponse.Result;

public class StoreManageServiceTest extends BaseTest{

	@Autowired
	private CarLeaseReserveService clrService;
	@Autowired
	private AuthorizedSessionService asService;
	
	@Test
	public void testStoreManage(){
		TmallCarLeaseReserveRequest req = new TmallCarLeaseReserveRequest();
		req.setBuyerId(123211313L);
		req.setOrderId(1321321321L);
		req.setText("车辆已到店，已预约消费者2015-05-12到店提车");
		req.setVin("AFafsadf");
		req.setFlag(1L);
		req.setBuyerNick("张三");
		try {
			TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", asService.getAppKey(), asService.getAppSecret());
			TmallCarLeaseReserveResponse rsp = client.execute(req, asService.getAuthorizedSession("花生好车旗舰店").getAccessToken());
			System.out.println("==========="+rsp.getBody());
			//res.getBody()返回值 json
			//结果存储对应表
			//StoreManage storeManage = (StoreManage) JSON.(rsp.getBody());
			clrService.addLeaseReserve(rsp);
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
