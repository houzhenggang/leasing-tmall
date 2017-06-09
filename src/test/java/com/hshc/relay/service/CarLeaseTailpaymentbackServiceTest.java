package com.hshc.relay.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hshc.relay.BaseTest;
import com.taobao.api.response.TmallCarLeaseTailpaymentbackResponse;

/**
 * 
 * @author 史珂
 * 2017年6月8日下午6:06:04
 */
public class CarLeaseTailpaymentbackServiceTest extends BaseTest {

	@Autowired
	private CarLeaseTailpaymentbackService carLeaseTailpaymentbackService;
	
	@Test
	public void testAdd(){
		TmallCarLeaseTailpaymentbackResponse.Result result = new TmallCarLeaseTailpaymentbackResponse.Result();
		result.setGmtCurrentTime(14969909135663L);
        result.setSuccess(false);
        result.setErrorCode("10000");
        result.setErrorMessage("错误信息");
        result.setMsgCode("10000");
        result.setMsgInfo("错误信息");
        Assert.assertEquals(1, carLeaseTailpaymentbackService.add(result));
	}
}
