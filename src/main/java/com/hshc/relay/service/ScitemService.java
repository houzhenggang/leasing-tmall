package com.hshc.relay.service;

import com.hshc.relay.dao.*;
import com.taobao.api.domain.ScItem;
import com.taobao.api.request.ScitemAddRequest;
import com.taobao.api.response.ScitemAddResponse;
import com.taobao.api.response.ScitemMapAddResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  发布后端商品
 *  @version V1.0 2017年5月7日16:36:36
 *  @author  王华英
 */
@Service
public class ScitemService extends BaseService<ScItem>{
    @Autowired
    private ScitemDao scitemDao;

    @Autowired
    private ScitemAddRequestDao scitemAddRequestDao;

    @Autowired
    private ScitemAddResponseDao scitemAddResponseDao;

    public void addScitem(ScItem sc, ScitemAddRequest reqSc, ScitemAddResponse repSc){
        scitemDao.insert(sc);
        scitemAddRequestDao.insert(reqSc);
        scitemAddResponseDao.insert(repSc);
    }

}
