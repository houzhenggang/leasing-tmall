package com.hshc.relay.service;

import java.util.List;

import com.hshc.relay.BaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.hshc.relay.BaseTest;
import com.hshc.relay.controller.erp.StoreManageController;
import com.hshc.relay.service.RequestTaobaoClientService;
import com.hshc.relay.service.StoreManageService;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.Store;
import com.taobao.api.request.InventoryStoreManageRequest;
import com.taobao.api.request.TmallCarLeaseConsumeRequest;
import com.taobao.api.request.TmallCarLeaseConsumeRequest.CosumeCodeReqDto;
import com.taobao.api.request.TmallCarLeaseReserveRequest;
import com.taobao.api.request.TmallCarLeaseTailpaymentbackRequest.TailPaymentDto;
import com.taobao.api.response.InventoryStoreManageResponse;
import com.taobao.api.response.TmallCarLeaseConsumeResponse;
import com.taobao.api.response.TmallCarLeaseReserveResponse;
import com.taobao.api.response.TmallCarLeaseTailpaymentbackResponse;
import com.taobao.api.response.TmallCarLeaseReserveResponse.Result;

public class StoreManageServiceTest extends BaseTest{

	public static final Logger LOGGER = LoggerFactory.getLogger(StoreManageController.class); 
	
	@Autowired
	CarLeaseConsumeService clcService;
	@Autowired
	private CarLeaseTailpaymentbackService cltService;
	
	@Test
	public void testStoreManage(){
		TailPaymentDto obj1 = new TailPaymentDto();
		obj1.setBuyerId(1312313L);
		obj1.setMonthlyPay(2000L);
		obj1.setMonths(12L);
		obj1.setName("分期付尾款");
		obj1.setOrderId(13131232132L);
		obj1.setTailAmount(80000L);
		try {
			//获取返回值
			TmallCarLeaseTailpaymentbackResponse leaseTailpaymentback = cltService.leaseTailpaymentback(obj1);
			//保存返回的信息
			cltService.addleaseTailpaymentback(leaseTailpaymentback.getResult());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
