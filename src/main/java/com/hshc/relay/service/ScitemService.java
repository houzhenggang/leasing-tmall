package com.hshc.relay.service;

import com.hshc.relay.dao.*;
import com.hshc.relay.entity.ISGetResponse;
import com.hshc.relay.entity.ScAddResponse;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.*;
import com.taobao.api.response.*;
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
    private AddScitemResponseDao addScitemResponseDao;
    @Autowired
    private ScitemGetRequestDao scitemGetRequestDao;
    @Autowired
    private  ScitemGetResponseDao scitemGetResponseDao;
    @Autowired
    private ScitemMapAddRequestDao scitemMapAddRequestDao;
    @Autowired
    private ScitemMapAddResponseDao scitemMapAddResponseDao;
    @Autowired
    private ItemSellerGetResponseDao itemSellerGetResponseDao;


    //获取单个商品详细信息
    public ISGetResponse getItemSeller(ItemSellerGetRequest reqSc) throws ApiException{
        TaobaoClient client = new DefaultTaobaoClient("https://eco.taobao.com/router/rest", authorizedSessionService.getAppKey(), authorizedSessionService.getAppSecret());
        ItemSellerGetResponse repSc=client.execute(reqSc, authorizedSessionService.getAuthorizedSession("花生好车旗舰店").getAccessToken());
        ISGetResponse rep=new ISGetResponse();
        rep.setItem(repSc.getItem());
        rep.setRepCode("一级错误码:"+repSc.getErrorCode()+";二级错误码:"+repSc.getSubCode());
        rep.setRepMsg("一级错误提示语：:"+repSc.getMsg()+";二级错误提示语："+repSc.getSubMsg());
        //单个商品详细信息持久化
        return rep;
    }

    //发布后端商品
    public ScAddResponse addScitem(ScitemAddRequest reqSc) throws ApiException {
        //请求后端商品
        TaobaoClient client = new DefaultTaobaoClient("https://eco.taobao.com/router/rest", authorizedSessionService.getAppKey(), authorizedSessionService.getAppSecret());
        ScitemAddResponse repSc=client.execute(reqSc, authorizedSessionService.getAuthorizedSession("花生好车旗舰店").getAccessToken());
        ScAddResponse rep=new ScAddResponse();
        rep.setScItem(repSc.getScItem());
        rep.setRepCode("一级错误码:"+repSc.getErrorCode()+";二级错误码:"+repSc.getSubCode());
        rep.setRepMsg("一级错误提示语：:"+repSc.getMsg()+";二级错误提示语："+repSc.getSubMsg());
        //持久化发布成功的商品
        if(repSc.getBody()!=null){
            addScitemResponseDao.insert(repSc);
        }
        return rep;
    }

    //查询根据后端商品id查询后端商品信息
    public ScitemGetResponse getScitem(ScitemGetRequest reqSc) throws ApiException{
        TaobaoClient client = new DefaultTaobaoClient("https://eco.taobao.com/router/rest", authorizedSessionService.getAppKey(), authorizedSessionService.getAppSecret());
        ScitemGetResponse repSc=client.execute(reqSc, authorizedSessionService.getAuthorizedSession("花生好车旗舰店").getAccessToken());
        //持久化后端商品
        //scitemGetResponseDao.insert(repSc);
        System.out.print("查询后端商品:"+repSc.getBody());
        return repSc;
    }

    //查询后端所有商品信息
    public ScitemQueryResponse queryScitem(ScitemQueryRequest reqSc) throws ApiException{
        TaobaoClient client = new DefaultTaobaoClient("https://eco.taobao.com/router/rest", authorizedSessionService.getAppKey(), authorizedSessionService.getAppSecret());
        ScitemQueryResponse repSc=client.execute(reqSc, authorizedSessionService.getAuthorizedSession("花生好车旗舰店").getAccessToken());
        //持久化后端商品
        //scitemGetResponseDao.insert(repSc);
        System.out.print("查询后端商品:"+repSc.getBody());
        return repSc;
    }

    //创建IC商品与后端商品的映射关系
    public ScitemMapAddResponse addScitemMap(ScitemMapAddRequest reqSc) throws ApiException{
        TaobaoClient client = new DefaultTaobaoClient("https://eco.taobao.com/router/rest", authorizedSessionService.getAppKey(), authorizedSessionService.getAppSecret());
        ScitemMapAddResponse repSc=client.execute(reqSc, authorizedSessionService.getAuthorizedSession("花生好车旗舰店").getAccessToken());
        //持久化IC商品与后端商品的映射关系
        //scitemMapAddResponseDao.insert(repSc);
        System.out.print("创建IC商品与后端商品的映射关系:"+repSc.getBody());
        return repSc;
    }

    //查询IC商品与后端商品的映射关系
    public ScitemMapQueryResponse queryScitemMap(ScitemMapQueryRequest reqSc) throws ApiException{
        TaobaoClient client = new DefaultTaobaoClient("https://eco.taobao.com/router/rest", authorizedSessionService.getAppKey(), authorizedSessionService.getAppSecret());
        ScitemMapQueryResponse repSc=client.execute(reqSc, authorizedSessionService.getAuthorizedSession("花生好车旗舰店").getAccessToken());
        //持久化IC商品与后端商品的映射关系
        //scitemMapAddResponseDao.insert(repSc);
        System.out.print("查询IC商品与后端商品的映射关系:"+repSc.getBody());
        return repSc;
    }


}
