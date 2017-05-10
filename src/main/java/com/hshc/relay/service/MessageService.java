package com.hshc.relay.service;

import com.hshc.relay.exception.BaseException;
import com.hshc.relay.service.messagehandler.DefaultMessageHandler;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.internal.tmc.Message;
import com.taobao.api.internal.tmc.TmcClient;
import com.taobao.api.internal.toplink.LinkException;
import com.taobao.api.request.TmcUserPermitRequest;
import com.taobao.api.response.TmcUserPermitResponse;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 钟林俊
 * @version V1.0 2017-05-09 13:49
 */
@Service
public class MessageService extends BaseService<Message> implements InitializingBean{

    @Autowired
    private AuthorizedSessionService authorizedSessionService;

    public void permitUser(String ... topics) throws ApiException {

        if(!ArrayUtils.isEmpty(topics)){
            String topicStr = topics[0];
            for(int i = 1; i < topics.length; i++){
                topicStr += "," + topics[i];
            }

            TaobaoClient client = new DefaultTaobaoClient(authorizedSessionService.getTopApi(), authorizedSessionService.getAppKey(), authorizedSessionService.getAppSecret());
            TmcUserPermitRequest req = new TmcUserPermitRequest();

            req.setTopics(topicStr);
            TmcUserPermitResponse rsp = client.execute(req, authorizedSessionService.getAuthorizedSession("花生好车旗舰店").getAccessToken());
            if(!rsp.getIsSuccess()){
                throw new BaseException(rsp.getSubCode(), rsp.getSubMsg());
            }
        }
    }

    @Override
    public void afterPropertiesSet(){
//        TmcClient client = new TmcClient(authorizedSessionService.getAppKey(), authorizedSessionService.getAppSecret());
//        client.setMessageHandler(new DefaultMessageHandler());
//        client.connect(authorizedSessionService.getMessageServiceUrl());
    }

    public void initClient() throws LinkException {
        TmcClient client = new TmcClient(authorizedSessionService.getAppKey(), authorizedSessionService.getAppSecret());
        client.setMessageHandler(new DefaultMessageHandler());
        client.connect(authorizedSessionService.getMessageServiceUrl());
    }
}
