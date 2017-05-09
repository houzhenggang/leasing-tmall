package com.hshc.relay.service;

import com.hshc.relay.dao.*;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.ScitemAddRequest;
import com.taobao.api.request.ScitemGetRequest;
import com.taobao.api.request.ScitemMapAddRequest;
import com.taobao.api.response.ScitemAddResponse;
import com.taobao.api.response.ScitemGetResponse;
import com.taobao.api.response.ScitemMapAddResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  商品信息
 *  @version V1.0 2017年5月7日16:36:36
 *  @author  王华英
 */
@Service
public class ScitemService extends BaseService<ScitemAddResponse>{
    @Autowired
    private AuthorizedSessionService authorizedSessionService;
    @Autowired
    private ScitemAddRequestDao scitemAddRequestDao;
    @Autowired
    private ScitemAddResponseDao scitemAddResponseDao;
    @Autowired
    private ScitemGetRequestDao scitemGetRequestDao;
    @Autowired
    private  ScitemGetResponseDao scitemGetResponseDao;
    @Autowired
    private ScitemMapAddRequestDao scitemMapAddRequestDao;
    @Autowired
    private ScitemMapAddResponseDao scitemMapAddResponseDao;

    //发布后端商品
    public ScitemAddResponse addScitem(ScitemAddRequest reqSc) throws ApiException {
        //scitemAddRequestDao.insert(reqSc);
        //请求后端商品

        TaobaoClient client = new DefaultTaobaoClient("https://eco.taobao.com/router/rest", authorizedSessionService.getAppKey(), authorizedSessionService.getAppSecret());
        ScitemAddResponse repSc=client.execute(reqSc, authorizedSessionService.getAuthorizedSession("花生好车旗舰店").getAccessToken());
        //持久化后端发布的商品
        //scitemAddResponseDao.insert(repSc);
        return repSc;
    }

    //查询后端商品
    public ScitemGetResponse getScitem(ScitemGetRequest reqSc) throws ApiException{
        TaobaoClient client = new DefaultTaobaoClient(reqSc.getApiMethodName(), authorizedSessionService.getAppKey(), authorizedSessionService.getAppSecret());
        ScitemGetResponse repSc=client.execute(reqSc, authorizedSessionService.getAuthorizedSession("花生好车旗舰店").getAccessToken());
        //持久化后端商品
        scitemGetResponseDao.insert(repSc);
        return repSc;
    }

    //创建IC商品与后端商品的映射关系
    public ScitemMapAddResponse addScitemMap(ScitemMapAddRequest reqSc) throws ApiException{
        TaobaoClient client = new DefaultTaobaoClient(reqSc.getApiMethodName(), authorizedSessionService.getAppKey(), authorizedSessionService.getAppSecret());
        ScitemMapAddResponse repSc=client.execute(reqSc, authorizedSessionService.getAuthorizedSession("花生好车旗舰店").getAccessToken());
        //持久化IC商品与后端商品的映射关系
        scitemMapAddResponseDao.insert(repSc);
        return repSc;
    }


}
