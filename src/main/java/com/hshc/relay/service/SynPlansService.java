package com.hshc.relay.service;

import com.hshc.relay.dao.TmallCarLeaseSynchronizeplansResponseDao;
import com.hshc.relay.entity.CLSynPlansResponse;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TmallCarLeaseSynchronizeplansRequest;
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

    public CLSynPlansResponse sysPlans(TmallCarLeaseSynchronizeplansRequest reqSyn) throws ApiException{
        TaobaoClient client = new DefaultTaobaoClient("https://eco.taobao.com/router/rest", authorizedSessionService.getAppKey(), authorizedSessionService.getAppSecret());
        TmallCarLeaseSynchronizeplansResponse repSyn=client.execute(reqSyn, authorizedSessionService.getAuthorizedSession("花生好车旗舰店").getAccessToken());
        CLSynPlansResponse rep=new CLSynPlansResponse();
        rep.setResult(repSyn.getResult());
        rep.setRepCode("一级错误码:"+repSyn.getErrorCode()+";二级错误码:"+repSyn.getSubCode());
        rep.setRepMsg("一级错误提示语:"+repSyn.getMsg()+";二级错误提示语："+repSyn.getSubMsg());
        System.out.println("result数据："+ repSyn.getResult().getErrorCode());
        System.out.println("result数据："+ repSyn.getResult().getErrorMessage());
        System.out.println("result数据："+ repSyn.getResult().getMsgCode());
        System.out.println("result数据："+ repSyn.getResult().getMsgInfo());
        System.out.println("result数据："+ repSyn.getResult().getCostTime());
        System.out.println("result数据："+ repSyn.getResult().getGmtCurrentTime());
        System.out.println("result数据："+ repSyn.getResult().getSuccess());
        //持久化租赁方案
        //tmallCarLeaseSynchronizeplansResponseDao.insert();
        return  rep;
    }
}
