package com.hshc.relay.service;

import com.hshc.relay.dao.TmallCarLeaseSynchronizeplansResponseDao;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TmallCarLeaseSynchronizeplansRequest;
import com.taobao.api.response.ScitemMapQueryResponse;
import com.taobao.api.response.TmallCarLeaseSynchronizeplansResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wanghuaying on 2017/5/10.
 */
@Service
public class SynPlansService extends BaseService<TmallCarLeaseSynchronizeplansResponse>{

    @Autowired
    private AuthorizedSessionService authorizedSessionService;

    @Autowired
    private TmallCarLeaseSynchronizeplansResponseDao tmallCarLeaseSynchronizeplansResponseDao;

    public TmallCarLeaseSynchronizeplansResponse sysPlans(TmallCarLeaseSynchronizeplansRequest reqSyn) throws ApiException{
        TaobaoClient client = new DefaultTaobaoClient("https://eco.taobao.com/router/rest", authorizedSessionService.getAppKey(), authorizedSessionService.getAppSecret());
        TmallCarLeaseSynchronizeplansResponse repSyn=client.execute(reqSyn, authorizedSessionService.getAuthorizedSession("花生好车旗舰店").getAccessToken());
        //持久化租赁方案
        //tmallCarLeaseSynchronizeplansResponseDao.insert();
        return  repSyn;
    }
}
