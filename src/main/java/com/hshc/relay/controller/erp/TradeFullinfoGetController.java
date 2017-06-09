package com.hshc.relay.controller.erp;

import com.hshc.relay.annotation.QimenSignAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hshc.relay.controller.BaseController;
import com.hshc.relay.service.TradeFullinfoGetService;
import com.hshc.relay.vo.BaseResponseVo;
import com.taobao.api.response.TradeFullinfoGetResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 获取单笔交易的详细信息
 * @author 史珂
 * 2017年5月11日上午10:07:01
 */
@Controller
public class TradeFullinfoGetController extends BaseController{

	@Autowired
	private TradeFullinfoGetService tfgService;
	
	@RequestMapping("/lease-trade")
	@ResponseBody
	@QimenSignAuthentication
	public BaseResponseVo getTradeFullinfo(Long tid){
		try {
			//获取单笔交易地详细信息
			TradeFullinfoGetResponse tradeFullinfo = tfgService.tradeFullinfo(tid);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new BaseResponseVo("获取单笔交易的详细信息成功");
	}

}
