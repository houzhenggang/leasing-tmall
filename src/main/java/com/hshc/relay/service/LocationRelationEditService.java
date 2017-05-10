package com.hshc.relay.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hshc.relay.dao.LocationRealtionEditDao;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.internal.util.json.JSONWriter;
import com.taobao.api.request.LocationRelationEditRequest;
import com.taobao.api.request.LocationRelationEditRequest.LocationRelationDto;
import com.taobao.api.response.LocationRelationEditResponse;
@Service
public class LocationRelationEditService extends BaseService<LocationRelationEditRequest>{
	@Autowired
    private AuthorizedSessionService authorizedSessionService;

	@Autowired
	private LocationRealtionEditDao  locationRealtionEditDao;
	public LocationRelationEditResponse locationRelationEdit(LocationRelationEditRequest locationRelationEditRequest) throws ApiException{
		List<LocationRelationDto> lo = locationRealtionEditDao.selectList(0, 500,null);
		
        TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", authorizedSessionService.getAppKey(), authorizedSessionService.getAppSecret());
        for(int i =0 ;i<lo.size();i++){
        	LocationRelationDto lr=  lo.get(i);
        	List<LocationRelationDto> loc = new  ArrayList<LocationRelationDto>();
        	loc.add(lr);
        	locationRelationEditRequest.setLocationRelationList(new JSONWriter(false,true).write(loc));
	        LocationRelationEditResponse rsp = client.execute(locationRelationEditRequest,authorizedSessionService.getAuthorizedSession("花生好车旗舰店").getAccessToken());
        }
		//LocationRelationEditResponse rsp = (LocationRelationEditResponse)RequestTaobaoService.requset(locationRelationEditRequest);

        
        return null;
	}

}
