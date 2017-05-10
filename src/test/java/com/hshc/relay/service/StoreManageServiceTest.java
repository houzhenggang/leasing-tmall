package com.hshc.relay.service;

import java.util.List;

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
import com.taobao.api.response.InventoryStoreQueryResponse;
import com.taobao.api.response.TmallCarLeaseConsumeResponse;
import com.taobao.api.response.TmallCarLeaseReserveResponse;
import com.taobao.api.response.TmallCarLeaseTailpaymentbackResponse;
import com.taobao.api.response.TmallCarLeaseReserveResponse.Result;

public class StoreManageServiceTest extends BaseTest{

	public static final Logger LOGGER = LoggerFactory.getLogger(StoreManageController.class); 
	
	@Autowired
	CarLeaseConsumeService clcService;
	@Autowired
	private StoreQueryService sqService;
	
	@Test
	public void testStoreManage(){
		String testck = "testck";
		try {
			//获取仓库信息
			InventoryStoreQueryResponse storeQuery = sqService.storeQuery(testck);
			LOGGER.info("storeQuery:"+storeQuery.getBody());
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
