package com.hshc.relay.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hshc.relay.BaseTest;
import com.taobao.api.response.TmallCarLeaseConsumeResponse;
/**
 * 
 * @author 史珂
 * 2017年6月8日下午6:06:14
 */
public class CarLeaseConsumeServiceTest extends BaseTest{

	@Autowired
	private CarLeaseConsumeService carLeaseConsumeService;
	
	@Test
	public void testAdd(){
		TmallCarLeaseConsumeResponse.Result result = new TmallCarLeaseConsumeResponse.Result();
        result.setGmtCurrentTime(14969909135663L);
        result.setSuccess(false);
        result.setErrorCode(10000L);
        result.setErrorMessage("错误信息");
        result.setGmtCurrentTime(100L);
        Assert.assertEquals(1, carLeaseConsumeService.add(result));
	}
}
