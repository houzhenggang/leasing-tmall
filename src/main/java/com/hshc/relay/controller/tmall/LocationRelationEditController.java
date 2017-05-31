package com.hshc.relay.controller.tmall;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hshc.relay.controller.BaseController;
import com.hshc.relay.service.LocationRelationEditService;
import com.taobao.api.ApiException;
import com.taobao.api.request.LocationRelationEditRequest;

@Controller
public class LocationRelationEditController extends BaseController{

	@Autowired
	private LocationRelationEditService locationRelationEditService;

	@RequestMapping(value="/realtion-edit")
	@ResponseBody
	public Map<String,Object> locationRelationEdit()throws ApiException{
		Map<String,Object> map = new HashMap<>();
		
		locationRelationEditService.locationRelationEdit(new LocationRelationEditRequest());
		return map;
	}
	
}
