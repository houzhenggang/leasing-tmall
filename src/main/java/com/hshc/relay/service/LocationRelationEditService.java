package com.hshc.relay.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hshc.relay.dao.LocationRealtionEditDao;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.LocationRelationEditRequest;
import com.taobao.api.response.LocationRelationEditResponse;
@Service
public class LocationRelationEditService extends BaseService<LocationRelationEditRequest>{
	@Autowired
    private AuthorizedSessionService authorizedSessionService;

	@Autowired
	private LocationRealtionEditDao  locationRealtionEditDao;
	public LocationRelationEditResponse locationRelationEdit() throws ApiException{
		List<LocationRelationEditRequest> lo = locationRealtionEditDao.selectList(0, 500,null);
		Logger.info(lo.get(0).toString());
        TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", authorizedSessionService.getAppKey(), authorizedSessionService.getAppSecret());
        //LocationRelationEditResponse rps = client.execute(locationRelationEditRequest,authorizedSessionService.getAuthorizedSession("花生好车旗舰店").getAccessToken());
        //Map<String, String> map = locationRelationEditRequest.getTextParams();
        //Logger.info(map.toString());
        //locationRealtionEditDao.insert();
        return null;
	}

}
