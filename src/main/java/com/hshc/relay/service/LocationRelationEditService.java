package com.hshc.relay.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
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
		LocationRelationEditResponse rsp = new LocationRelationEditResponse();
		List<LocationRelationDto> lo = locationRealtionEditDao.selectList(0, 500,null);
		
        TaobaoClient client = new DefaultTaobaoClient(getTopApi(), getAppKey(), getAppSecret());

		for (LocationRelationDto lr : lo) {
			List<LocationRelationDto> loc = new ArrayList<>();
			loc.add(lr);
			locationRelationEditRequest.setLocationRelationList(new JSONWriter(false, true).write(loc));
			rsp = client.execute(locationRelationEditRequest, asService.getAuthorizedSession("花生好车旗舰店").getAccessToken());
			logger.info("getBody:" + JSON.toJSONString(rsp));
//        	if(((i+1)/20)==0){
//        		locationRelationEditRequest.setLocationRelationList(new JSONWriter(false,true).write(loc));
//                rsp = client.execute(locationRelationEditRequest,asService.getAuthorizedSession("花生好车旗舰店").getAccessToken());
//                loc = new  ArrayList<LocationRelationDto>();
//                LOGGER.info("getBody:"+JSON.toJSONString(rsp));
//        	}
//        	if((i+1)==lo.size()){
//        		locationRelationEditRequest.setLocationRelationList(new JSONWriter(false,true).write(loc));
//                rsp = client.execute(locationRelationEditRequest,asService.getAuthorizedSession("花生好车旗舰店").getAccessToken());
//                loc = new  ArrayList<LocationRelationDto>();
//                LOGGER.info("getBody:"+JSON.toJSONString(rsp));
//        	}

		}
        return rsp;
	}

	public LocationRelationQueryResponse locationRelationQuery() throws ApiException{
		LocationRelationQueryRequest locationRelationQueryRequest = new LocationRelationQueryRequest();
		LocationRelationQueryResponse rsp = new LocationRelationQueryResponse();
		List<LocationRelationDto> lo = locationRealtionEditDao.selectList(0, 500,null);
		
        TaobaoClient client = new DefaultTaobaoClient(asService.getTopApi(), asService.getAppKey(), asService.getAppSecret());

		for (LocationRelationDto lr : lo) {
			//        	List<LocationRelationDto> loc = new  ArrayList<LocationRelationDto>();
//        	loc.add(lr);
			locationRelationQueryRequest.setLocationRelation(new JSONWriter(false, true).write(lr));
			rsp = client.execute(locationRelationQueryRequest, asService.getAuthorizedSession("花生好车旗舰店").getAccessToken());
			logger.info("getBody:" + JSON.toJSONString(rsp));

		}
    	       
        return rsp;
	}

}
