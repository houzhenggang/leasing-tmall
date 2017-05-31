package com.hshc.relay.controller.erp;

import com.taobao.api.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hshc.relay.annotation.QimenSignAuthentication;
import com.hshc.relay.controller.BaseController;
import com.hshc.relay.service.StoreQueryService;
import com.hshc.relay.vo.BaseResponseVo;
import com.taobao.api.response.InventoryStoreQueryResponse;

/**
 * 查询仓库信息
 * @author 史珂
 * 2017年5月10日下午5:02:09
 */
@Controller
public class StoreQueryController extends BaseController{
	
	@Autowired
	private StoreQueryService sqService;
	
	@RequestMapping("/lease-storeQuery")
	@ResponseBody
	@QimenSignAuthentication
	public BaseResponseVo storeQuery(@RequestParam("store_code") String storeCode) throws ApiException {
		//获取仓库信息
		InventoryStoreQueryResponse storeQuery = sqService.storeQuery(storeCode);
		logger.info("storeQuery:"+storeQuery.getBody());
		return new BaseResponseVo("查询仓库信息成功");
	}
}
