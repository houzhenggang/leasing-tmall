package com.hshc.relay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TmallCarLeaseReserveRequest;
import com.taobao.api.response.TmallCarLeaseReserveResponse;

/**
 * 整车租车回传预约信息
 * @author 史珂 2017年5月9日14:00:43
 *
 */
@Service
public class CarLeaseReserveService extends BaseService<TmallCarLeaseReserveResponse.Result, TmallCarLeaseReserveResponse.Result>{

	@Autowired
	private AuthorizedSessionService asService;

	public TmallCarLeaseReserveResponse leaseReserve(TmallCarLeaseReserveRequest req) throws ApiException {
		// TODO Auto-generated method stub
		if(req.getBuyerId() == null){
			req.setBuyerId((long) 0);
		}
		
		TaobaoClient client = new DefaultTaobaoClient(asService.getTopApi(), asService.getAppKey(), asService.getAppSecret());
		return client.execute(req, asService.getAuthorizedSession("花生好车旗舰店").getAccessToken());
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int add(TmallCarLeaseReserveResponse.Result result) {
		result.setLeaseType("整车租车回传预约信息");
		return baseDao.insert(result);
	}

}
