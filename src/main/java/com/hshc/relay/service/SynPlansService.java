package com.hshc.relay.service;

import com.hshc.relay.dao.TmallCarLeaseSynchronizeplansResponseDao;
import com.hshc.relay.entity.CLSynPlansResponse;
import com.qimencloud.api.response.HshcRiskcontolOrdersReturnResponse;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TmallCarLeaseSynchronizeplansRequest;
import com.taobao.api.response.TmallCarLeaseSynchronizeplansResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * Created by wanghuaying on 2017/5/10.
 */
@Service
public class SynPlansService extends BaseService<TmallCarLeaseSynchronizeplansRequest>{

    @Autowired
    private AuthorizedSessionService authorizedSessionService;

    public CLSynPlansResponse sysPlans(final TmallCarLeaseSynchronizeplansRequest tmallCarLeaseSynchronizeplansRequest) throws ApiException{
        final  CLSynPlansResponse rep=new CLSynPlansResponse();

        //方案可能是同一个方案多次发送, 所以先update，再add
        if(modify(tmallCarLeaseSynchronizeplansRequest)==0){
            //持久化租赁方案
            add(tmallCarLeaseSynchronizeplansRequest);
        }

        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCommit(){
                try {
                    // 事务提交后再执行（跟租赁系统通信）
                    TaobaoClient client = new DefaultTaobaoClient("https://eco.taobao.com/router/rest", authorizedSessionService.getAppKey(), authorizedSessionService.getAppSecret());
                    TmallCarLeaseSynchronizeplansResponse tmallCarLeaseSynchronizeplansResponse=client.execute(tmallCarLeaseSynchronizeplansRequest, authorizedSessionService.getAuthorizedSession("花生好车旗舰店").getAccessToken());
                    rep.setResult(tmallCarLeaseSynchronizeplansResponse.getResult());
                    rep.setRepCode("一级错误码:"+tmallCarLeaseSynchronizeplansResponse.getErrorCode()+";二级错误码:"+tmallCarLeaseSynchronizeplansResponse.getSubCode());
                    rep.setRepMsg("一级错误提示语:"+tmallCarLeaseSynchronizeplansResponse.getMsg()+";二级错误提示语："+tmallCarLeaseSynchronizeplansResponse.getSubMsg());

                    //更新方案中与天猫交互的状态

                }catch (ApiException e){
                    e.printStackTrace();
                }
            }
        });

        return  rep;
    }
}
