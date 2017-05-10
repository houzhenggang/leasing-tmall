package com.hshc.relay.service.messagehandler;

import com.hshc.relay.service.BaseService;
import com.taobao.api.internal.tmc.Message;
import com.taobao.api.internal.tmc.MessageHandler;
import com.taobao.api.internal.tmc.MessageStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.SpringUtil;

/**
 * @author 钟林俊
 * @version V1.0 2017-05-09 19:22
 */
@Service
public class DefaultMessageHandler extends BaseService<Message> implements MessageHandler {
    @Transactional(rollbackFor = Exception.class)
    public void onMessage(Message message, MessageStatus status) {
        try {
            baseDao.insert(message);
//                throw new RuntimeException();
            HshcMessageHandler messageHandler = getMessageHandler(message.getTopic());
            if(messageHandler != null){
                messageHandler.handle(message);
            }
        } catch (Exception e) {
            logger.error("", e);
            // 消息处理失败回滚，服务端需要重发
            status.setReason(e.getMessage());
            status.fail();
        }
    }

    private HshcMessageHandler getMessageHandler(String topic) {
        switch (topic){
            case "taobao_trade_TradeBuyerPay ": return SpringUtil.getBeanByClass(TradeMessageHandler.class);
        }

        return null;
    }

}
