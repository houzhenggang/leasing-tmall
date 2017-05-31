package com.hshc.relay.controller.erp;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hshc.relay.annotation.QimenSignAuthentication;
import com.hshc.relay.controller.BaseController;
import com.hshc.relay.service.StoreManageService;
import com.hshc.relay.vo.BaseResponseVo;
import com.taobao.api.ApiException;
import com.taobao.api.domain.Store;
import com.taobao.api.request.InventoryStoreManageRequest;
import com.taobao.api.response.InventoryStoreManageResponse;

/**
 * 创建/更新仓库
 * @author 史珂 2017年5月7日09:56:18
 *
 */
@Controller
public class StoreManageController extends BaseController{

	@Autowired
	protected StoreManageService smService;

	@RequestMapping("/lease-storeManage")
	@ResponseBody
	@QimenSignAuthentication
	public BaseResponseVo storeManager(@Valid InventoryStoreManageRequest smr) throws ApiException {
		//获得返回值
		Store store = smService.getStoreManage(smr);
		//res.getBody()返回值 json
		//结果存储对应表
		if(smr.getOperateType().equals("ADD")){
			smService.add(store);
		}else if(smr.getOperateType().equals("UPDATE")){
			smService.modify(store);
		}
		return new BaseResponseVo("创建/更新成功");
	}


}
