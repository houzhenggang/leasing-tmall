package com.hshc.relay.service;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.UserSellerGetRequest;
import com.taobao.api.response.ScitemAddResponse;
import com.taobao.api.response.UserSellerGetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version  2017年5月12日09:43:14
 * @author  王华英
 */
@Service
public class UserSellerGetService extends BaseService<UserSellerGetResponse, UserSellerGetResponse>{

    @Autowired
    private AuthorizedSessionService authorizedSessionService;

    public UserSellerGetResponse getUserSeller(UserSellerGetRequest reqSc)throws ApiException{
        //请求后端商品
        TaobaoClient client = new DefaultTaobaoClient(getTopApi(), getAppKey(), getAppSecret());
        return client.execute(reqSc, authorizedSessionService.getAuthorizedSession("花生好车旗舰店").getAccessToken());
    }
}
