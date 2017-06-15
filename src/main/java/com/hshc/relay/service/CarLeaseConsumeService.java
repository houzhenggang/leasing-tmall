package com.hshc.relay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TmallCarLeaseConsumeRequest;
import com.taobao.api.response.TmallCarLeaseConsumeResponse;
import org.springframework.transaction.annotation.Transactional;

/**
 * 汽车租赁核销
 * @author 史珂
 * 2017年5月10日上午10:14:03
 */
@Service
public class CarLeaseConsumeService extends BaseService<TmallCarLeaseConsumeResponse.Result, TmallCarLeaseConsumeResponse.Result> {

	@Autowired
	private AuthorizedSessionService asService;

	public TmallCarLeaseConsumeResponse leaseConsume(TmallCarLeaseConsumeRequest req) throws ApiException {
		TaobaoClient client = new DefaultTaobaoClient(getTopApi(), getAppKey(), getAppSecret());

		return client.execute(req, asService.getAuthorizedSession("花生好车旗舰店").getAccessToken());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int add(TmallCarLeaseConsumeResponse.Result result){
		result.setLeaseType("汽车租赁核销");
		return baseDao.insert(result);
	}

}
