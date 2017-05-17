//package com.hshc.relay.service;
//
//
//import com.hshc.relay.BaseTest;
//import org.junit.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.hshc.relay.controller.erp.StoreManageController;
//
//
//public class StoreManageServiceTest extends BaseTest{
//
//	public static final Logger LOGGER = LoggerFactory.getLogger(StoreManageController.class); 
//	
//	@Autowired
//	CarLeaseConsumeService clcService;
//	@Autowired
//	private StoreQueryService sqService;
//	@Autowired
//	private TradeFullinfoGetService tfgService;
//	
//	@Test
//	public void testStoreManage(){
//		long tid = 14089600409706726L;
//		try {
//			//获取单笔交易地详细信息
//			/*TradeFullinfoGetResponse tradeFullinfo = tfgService.tradeFullinfo(tid);
//			LOGGER.info("tradeFullinfo:"+tradeFullinfo.getBody());
//			//保存订单信息
//			//tfgService.addtradeFullinfo(tradeFullinfo.getTrade());
//			//把数据传给erp
//			tfgService.toErp(tradeFullinfo.getTrade());*/
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//
//	}
//}
