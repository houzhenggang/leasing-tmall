package com.hshc.relay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TmallCarLeaseReserveRequest;
import com.taobao.api.response.TmallCarLeaseReserveResponse;
@Service
public class CarLeaseReserveService extends BaseService<TmallCarLeaseReserveResponse>{

	@Autowired
	private AuthorizedSessionService asService;
	
	public void leaseReserve(TmallCarLeaseReserveRequest req) {
		// TODO Auto-generated method stub
		if(req.getBuyerId()==null||req.getBuyerId().equals("")){
			req.setBuyerId((long) 0);
		}
		try {
			TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", asService.getAppKey(), asService.getAppSecret());
			TmallCarLeaseReserveResponse rsp = client.execute(req, asService.getAuthorizedSession("花生好车旗舰店").getAccessToken());
			
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
