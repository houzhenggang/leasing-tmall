package com.hshc.relay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hshc.relay.dao.StoreManageDao;
import com.taobao.api.domain.Store;
@Service
public class StoreManageService extends BaseService<Store>{

	@Autowired
	protected StoreManageDao smDao;
	
	@Transactional
	public void addStoreList(Store storeManage) {
		smDao.insert(storeManage);
	}
	
	@Transactional
	public void upStoreList(Store storeManage) {
		// TODO Auto-generated method stub
		smDao.update(storeManage);
	}

}
