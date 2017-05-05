package com.hshc.relay.api.tmall;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.internal.util.StringUtils;
import  com.taobao.api.request.FenxiaoDistributorProductsGetRequest;


/**
 * Created by wanghuaying on 2017/5/5.
 */

public class FenxiaoDistributorProductsGet {
    public  void test(){
       // TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        FenxiaoDistributorProductsGetRequest req = new FenxiaoDistributorProductsGetRequest();
        req.setEndTime(StringUtils.parseDateTime("2000-01-01 00:00:00"));
        req.setFields("skus");
        req.setItemIds("1001,1002,1003,1004,1005");
        req.setProductcatId(3232312L);
        req.setPids("1001,1002,1003,1004,1005");
        req.setStartTime(StringUtils.parseDateTime("2000-01-01 00:00:00"));
        req.setPageNo(1L);
        req.setPageSize(20L);
        req.setSupplierNick("test");

    }



}
