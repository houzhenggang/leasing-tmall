package com.hshc.relay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TmallCarLeaseReserveRequest;
import com.taobao.api.response.TmallCarLeaseReserveResponse;
import com.taobao.api.response.TmallCarLeaseReserveResponse.Result;
/**
 * 整车租车回传预约信息
 * @author 史珂 2017年5月9日14:00:43
 *
 */
@Service
public class CarLeaseReserveService extends BaseService<TmallCarLeaseReserveResponse>{

	@Autowired
	private AuthorizedSessionService asService;
	
	public TmallCarLeaseReserveResponse leaseReserve(TmallCarLeaseReserveRequest req) throws ApiException {
		// TODO Auto-generated method stub
		if(req.getBuyerId()==null||req.getBuyerId().equals("")){
			req.setBuyerId((long) 0);
		}
		TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", asService.getAppKey(), asService.getAppSecret());
		TmallCarLeaseReserveResponse rsp = client.execute(req, asService.getAuthorizedSession("花生好车旗舰店").getAccessToken());
		return rsp;
	}

	public void addLeaseReserve(TmallCarLeaseReserveResponse lr) {
		Result result = lr.getResult();
		
	}

}
