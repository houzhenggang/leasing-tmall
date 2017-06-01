package com.hshc.relay.controller.tmall;

import java.util.HashMap;
import java.util.Map;

import com.hshc.relay.vo.BaseResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hshc.relay.controller.BaseController;
import com.hshc.relay.controller.erp.ScitemController;
import com.hshc.relay.service.LocationRelationEditService;
import com.taobao.api.ApiException;
import com.taobao.api.response.LocationRelationEditResponse;


@Controller
public class LocationRelationEditController extends BaseController{
    private static Logger LOGGER = LoggerFactory.getLogger(ScitemController.class);

	@Autowired
	private LocationRelationEditService locationRelationEditService;

	@RequestMapping(value="/realtion-edit")
	@ResponseBody
	public BaseResponseVo locationRelationEdit()throws ApiException{
		LocationRelationEditResponse rsp =  new LocationRelationEditResponse();
		try{
	    rsp = locationRelationEditService.locationRelationEdit();
		LOGGER.info("getBody:"+JSON.toJSONString(rsp));
	} catch (Exception e) {
		new BaseResponseVo(false,JSON.toJSONString(rsp));
	}
	return new BaseResponseVo(true,JSON.toJSONString(rsp));
	}
	
}
