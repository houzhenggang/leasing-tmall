package com.hshc.relay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TmallCarLeaseTailpaymentbackRequest;
import com.taobao.api.response.TmallCarLeaseTailpaymentbackResponse;
import com.taobao.api.response.TmallCarLeaseTailpaymentbackResponse.Result;

/**
 * 尾款处置方案回传
 * @author 史珂
 * 2017年5月10日下午3:13:03
 */
@Service
public class CarLeaseTailpaymentbackService extends BaseService<TmallCarLeaseTailpaymentbackResponse.Result, TmallCarLeaseTailpaymentbackResponse.Result> {

	@Autowired
	private AuthorizedSessionService asService;

	public TmallCarLeaseTailpaymentbackResponse leaseTailpaymentback(TmallCarLeaseTailpaymentbackRequest req) throws ApiException {
		TaobaoClient client = new DefaultTaobaoClient(getTopApi(), getAppKey(), getAppSecret());
		return client.execute(req, asService.getAuthorizedSession("花生好车旗舰店").getAccessToken());
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int add(Result result) {
		result.setLeaseType("尾款处置方案回传");
		return baseDao.insert(result);
	}

}
