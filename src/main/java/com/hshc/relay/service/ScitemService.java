package com.hshc.relay.service;

import com.hshc.relay.dao.BaseDao;
import com.taobao.api.domain.ScItem;
import org.springframework.stereotype.Service;

/**
 *  发布后端商品
 *  @version V1.0 2017年5月7日16:36:36
 *  @author  王华英
 */
@Service
public class ScitemService extends BaseService<ScItem>{
    public void addScitem(ScItem sc){
        baseDao.insert(sc);
    }

}
