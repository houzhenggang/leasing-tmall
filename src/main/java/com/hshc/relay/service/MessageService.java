package com.hshc.relay.service;

import com.hshc.relay.exception.BaseException;
import com.hshc.relay.service.messagehandler.HshcMessageHandler;
import com.hshc.relay.service.messagehandler.TradeMessageHandler;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.internal.tmc.Message;
import com.taobao.api.internal.tmc.MessageHandler;
import com.taobao.api.internal.tmc.MessageStatus;
import com.taobao.api.internal.tmc.TmcClient;
import com.taobao.api.request.TmcUserPermitRequest;
import com.taobao.api.response.TmcUserPermitResponse;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.SpringUtil;

/**
 * @author 钟林俊
 * @version V1.0 2017-05-09 13:49
 */
@Service
public class MessageService extends BaseService<Message> implements InitializingBean{

    @Autowired
    private AuthorizedSessionService authorizedSessionService;

    private HshcMessageHandler getMessageHandler(String topic) {
        switch (topic){
            case "taobao_trade_TradeBuyerPay ": return SpringUtil.getBeanByClass(TradeMessageHandler.class);
        }

        return null;
    }

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
    public void afterPropertiesSet() throws Exception {
        TmcClient client = new TmcClient(authorizedSessionService.getAppKey(), authorizedSessionService.getAppSecret());
        client.setMessageHandler(SpringUtil.getBeanByClass(DefaultMessageHandler.class));
        client.connect(authorizedSessionService.getMessageServiceUrl());
    }


    @Service
    private class DefaultMessageHandler implements MessageHandler{

        @Transactional
        public void onMessage(Message message, MessageStatus status) {
//            try {
                baseDao.insert(message);
                throw new RuntimeException();
//                HshcMessageHandler messageHandler = getMessageHandler(message.getTopic());
//                if(messageHandler != null){
//                    messageHandler.handle(message);
//                }
//            } catch (Exception e) {
//                logger.error("", e);
//                // 消息处理失败回滚，服务端需要重发
//                status.setReason(e.getMessage());
//                status.fail();
//            }
        }
    }

}
