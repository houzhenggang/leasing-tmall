package com.hshc.relay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TmallCarLeaseConsumeRequest.CosumeCodeReqDto;
import com.taobao.api.response.TmallCarLeaseConsumeResponse;
/**
 * 汽车租赁核销
 * @author 史珂
 * 2017年5月10日上午10:14:03
 */
@Service
public class CarLeaseConsumeService extends BaseService<TmallCarLeaseConsumeResponse> {

	@Autowired
	private AuthorizedSessionService asService;
	
	public void leaseConsume(CosumeCodeReqDto cosumeCodeReqDto) {
		TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", asService.getAppKey(), asService.getAppSecret());
		//TmallCarLeaseConsumeRequest req = new TmallCarLeaseConsumeRequest();
	}

	
}
