package com.hshc.relay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hshc.relay.dao.StoreManageDao;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.Store;
import com.taobao.api.request.InventoryStoreManageRequest;
import com.taobao.api.response.InventoryStoreManageResponse;

/**
 * 创建更新仓库
 * @author 史珂
 *
 */
@Service
public class StoreManageService extends BaseService<Store>{

	@Autowired
	private AuthorizedSessionService asService;
	
	public Store getStoreManage(InventoryStoreManageRequest smr) throws ApiException {
		TaobaoClient client = new DefaultTaobaoClient(getTopApi(),getAppKey(), getAppSecret());
		InventoryStoreManageResponse res = client.execute(smr, asService.getAuthorizedSession("花生好车旗舰店").getAccessToken());
		return res.getStoreList().get(0);
	}

}
