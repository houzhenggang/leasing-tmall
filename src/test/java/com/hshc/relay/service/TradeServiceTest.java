package com.hshc.relay.service;

import com.hshc.relay.BaseTest;
import com.hshc.relay.service.messagehandler.TradeMessageHandler;
import com.taobao.api.ApiException;
import com.taobao.api.internal.tmc.Message;
import com.taobao.api.internal.toplink.LinkException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 钟林俊
 * @version V1.0 2017-05-09 11:07
 */
public class TradeServiceTest extends BaseTest {

    @Autowired
    private TradeService tradeService;

    @Autowired
    private TradeMessageHandler tradeMessageHandler;

    @Test
    public void testGetTradeFullInfo() throws LinkException, InterruptedException, ApiException {
        Message message = new Message();
        message.setContent("{\"tid\": 16672909198796349}");
        message.setTopic("taobao_trade_TradeBuyerPay");
        tradeMessageHandler.handle(message);
    }

}
