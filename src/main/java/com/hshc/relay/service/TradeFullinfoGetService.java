package com.hshc.relay.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hshc.relay.controller.erp.StoreManageController;
import com.hshc.relay.dao.OrderDao;
import com.hshc.relay.dao.TradeDao;
import com.taobao.api.ApiException;
import com.taobao.api.domain.Order;
import com.taobao.api.domain.Trade;
import com.taobao.api.request.TradeFullinfoGetRequest;
import com.taobao.api.response.TradeFullinfoGetResponse;
/**
 * 获取单笔交易的详细信息
 * @author 史珂
 * 2017年5月11日上午10:55:52
 */
@Service
public class TradeFullinfoGetService extends BaseService<TradeFullinfoGetResponse>{
	public static final Logger LOGGER = LoggerFactory.getLogger(StoreManageController.class); 
	
	//@Autowired
	//private AuthorizedSessionService asService;
	@Autowired
	private TradeDao tDao;
	@Autowired
	private OrderDao oDao;
	
	
	public TradeFullinfoGetResponse tradeFullinfo(Long tid) throws ApiException {
		//TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", asService.getAppKey(), asService.getAppSecret());
		//TradeFullinfoGetResponse rsp = client.execute(req, asService.getAuthorizedSession("花生好车旗舰店").getAccessToken());
		TradeFullinfoGetRequest req = new TradeFullinfoGetRequest();
		req.setFields("tid,title,type,status,payment,est_con_time,receiver_name,receiver_state,receiver_address,receiver_mobile,receiver_phone,orders,buyer_nick");
		req.setTid(tid);
		TradeFullinfoGetResponse rsp = (TradeFullinfoGetResponse)RequestTaobaoClientService.requset(req);
        return rsp;		
	}

	@Transactional(rollbackFor = Exception.class)
	public void addtradeFullinfo(Trade trade) {
		//添加主订单信息
		tDao.insert(trade);
		Long tid = trade.getTid();
		List<Order> orders = trade.getOrders();
		for (Order order : orders) {
			order.setTid((long) tid);
			//保存子订单
			oDao.insert(order);
		}
	}

	public void toErp(Trade trade) {
		//实体转化json
		String str=JSON.toJSONStringWithDateFormat(trade, "yyyy-MM-dd HH:mm:ss",SerializerFeature.DisableCircularReferenceDetect);
		LOGGER.info("str:"+str);
	}

	
}
