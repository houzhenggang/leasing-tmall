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
import com.taobao.api.request.LocationRelationQueryRequest;
import com.taobao.api.response.LocationRelationEditResponse;
import com.taobao.api.response.LocationRelationQueryResponse;
@Service
public class LocationRelationEditService extends BaseService<LocationRelationEditRequest>{
	@Autowired
    private AuthorizedSessionService asService;

	@Autowired
	private LocationRealtionEditDao  locationRealtionEditDao;
	public LocationRelationEditResponse locationRelationEdit() throws ApiException{
		LocationRelationEditRequest locationRelationEditRequest = new LocationRelationEditRequest();
		List<LocationRelationDto> lo = locationRealtionEditDao.selectList(0, 500,null);
		
        TaobaoClient client = new DefaultTaobaoClient(asService.getTopApi(), asService.getAppKey(), asService.getAppSecret());
        for(int i =0 ;i<lo.size();i++){
        	LocationRelationDto lr=  lo.get(i);
        	List<LocationRelationDto> loc = new  ArrayList<LocationRelationDto>();
        	loc.add(lr);
        	locationRelationEditRequest.setLocationRelationList(new JSONWriter(false,true).write(loc));
	        
        }
        LocationRelationEditResponse rsp = client.execute(locationRelationEditRequest,asService.getAuthorizedSession("花生好车旗舰店").getAccessToken());
        
        return rsp;
	}
	public LocationRelationQueryResponse locationRelationQuery() throws ApiException{
		LocationRelationQueryRequest locationRelationQueryRequest = new LocationRelationQueryRequest();
		List<LocationRelationDto> lo = locationRealtionEditDao.selectList(0, 500,null);
		
        TaobaoClient client = new DefaultTaobaoClient(asService.getTopApi(), asService.getAppKey(), asService.getAppSecret());
        List<LocationRelationDto> loc = new  ArrayList<LocationRelationDto>();
        for(int i =0 ;i<lo.size();i++){
        	LocationRelationDto lr=  lo.get(i);
        	loc.add(lr);
        }
    	locationRelationQueryRequest.setLocationRelation(new JSONWriter(false,true).write(loc));
        LocationRelationQueryResponse rsp = client.execute(locationRelationQueryRequest,asService.getAuthorizedSession("花生好车旗舰店").getAccessToken());
        
        return rsp;
	}

}
