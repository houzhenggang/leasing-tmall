package com.hshc.relay.service.messagehandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.hshc.relay.dao.TradeFullinfoGetResponseDao;
import com.hshc.relay.entity.taobaomessage.TradeBuyerPayMessage;
import com.hshc.relay.service.AuthorizedSessionService;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.internal.tmc.Message;
import com.taobao.api.request.TradeFullinfoGetRequest;
import com.taobao.api.response.TradeFullinfoGetResponse;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import util.SpringUtil;

/**
 * @author 钟林俊
 * @version V1.0 2017-05-09 14:54
 */
@Component
public class TradeMessageHandler implements HshcMessageHandler {

    @Override
    public void handle(Message message) throws ApiException {

        if("taobao_trade_TradeBuyerPay".equals(message.getTopic()) ){

            TradeBuyerPayMessage tradeBuyerPayMessage = JSON.parseObject(message.getContent(), TradeBuyerPayMessage.class, Feature.UseBigDecimal);

            AuthorizedSessionService authorizedSessionService = SpringUtil.getBeanByClass(AuthorizedSessionService.class);

            TaobaoClient client = new DefaultTaobaoClient(authorizedSessionService.getTopApi(), authorizedSessionService.getAppKey(), authorizedSessionService.getAppSecret());

            TradeFullinfoGetRequest req = new TradeFullinfoGetRequest();
//            seller_nick,buyer_nick,title,type,created,sid,tid,seller_rate,buyer_rate,status,payment,discount_fee,adjust_fee,post_fee,
//            total_fee,pay_time,end_time,modified,consign_time,buyer_obtain_point_fee,point_fee,real_point_fee,received_payment,commission_fee,
//            pic_path,num_iid,num,price,cod_fee,cod_status,shipping_type,receiver_name,receiver_state,receiver_city,receiver_district,
//            receiver_address,receiver_zip,receiver_mobile,receiver_phone,orders
            req.setFields("tid,type,status,payment,orders");
            req.setTid(tradeBuyerPayMessage.getTid());

            TradeFullinfoGetResponse fullinfoGetResponse = client.execute(req, authorizedSessionService.getAuthorizedSession("花生好车旗舰店").getAccessToken());

            SpringUtil.getBeanByClass(TradeFullinfoGetResponseDao.class).insert(fullinfoGetResponse);

//
        }
    }

}
