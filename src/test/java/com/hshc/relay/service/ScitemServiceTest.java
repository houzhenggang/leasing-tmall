package com.hshc.relay.service;

import com.hshc.relay.BaseTest;
import com.hshc.relay.service.ScitemService;
import com.taobao.api.ApiException;
import com.taobao.api.domain.ScItem;
import com.taobao.api.request.*;
import com.taobao.api.response.ScitemAddResponse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wanghuaying on 2017/5/8.
 */
public class ScitemServiceTest extends BaseTest{
    @Autowired
    private ScitemService scitemService;

    @Test
    public void testgetItemSeller() throws ApiException{
        //num_iid  550367105833
        ItemSellerGetRequest reqSc =new ItemSellerGetRequest();
        reqSc.setFields("num_iid,title,nick,price,approve_status,sku,outer_id");
        reqSc.setNumIid(550471303845L);//前端商品ID
        scitemService.getItemSeller(reqSc);
    }

    //查询后端商品
    @Test
    public void testGetScitem()throws ApiException{
        ScitemGetRequest reqSc =new ScitemGetRequest();
        reqSc.setItemId(550389528294L);
        scitemService.getScitem(reqSc);
    }

    @Test
    public void testQueryScitem() throws ApiException{
        ScitemQueryRequest reqSc=new ScitemQueryRequest();
        scitemService.queryScitem(reqSc);
    }

    @Test
    public void testAddScitem() throws ApiException {
        ScitemAddRequest req =new ScitemAddRequest();
        req.setItemName("测试车型DD");
        req.setOuterCode("hs2017DD");
        /*req.setItemType(0L);
        req.setProperties("111:222;333:444");
        req.setBarCode("条形码");
        req.setWmsCode("仓储商编码");
        req.setIsFriable(0L);
        req.setIsDangerous(0L);
        req.setIsCostly(0L);
        req.setIsWarranty(0L);
        req.setWeight(1L);
        req.setLength(1L);
        req.setWidth(1L);
        req.setHeight(1L);
        req.setVolume(1L);
        req.setPrice(1L);
        req.setRemark("remark");
        req.setMatterStatus(0L);
        req.setBrandId(1L);
        req.setBrandName("brand_Name");
        req.setSpuId(1234L);
        req.setIsAreaSale(1L);*/


      /*  ScitemAddResponse rep =new ScitemAddResponse();
        ScItem scItem=new ScItem();
        scItem.setItemId(new Long(""));
        scItem.setItemName("秋装款式1");
        scItem.setOuterCode("GLY111222");
        scItem.setItemType(new Long(1));
        scItem.setProperties("height:20;length:5");
        scItem.setBarCode("NMB12341");
        scItem.setWmsCode("仓储商编码");
        scItem.setIsFriable(true);
        scItem.setIsDangerous(true);
        scItem.setIsCostly(true);
        scItem.setIsWarranty(true);
        scItem.setWeight(new Long(1000));
        scItem.setLength(new Long(1000));
        scItem.setWidth(new Long(1000));
        scItem.setHeight(new Long(1000));
        scItem.setVolume(new Long(1000));
        scItem.setPrice(new Long(1000));
        scItem.setRemark("备注");
        scItem.setMatterStatus("LIQUIDLIQUID");
        scItem.setBrandId(new Long(111));
        scItem.setBrandName("品牌名称");
        scItem.setIsAreaSale(new Long(1));
        scItem.setOptions(new Long(16));
        rep.setScItem(scItem);*/
        scitemService.addScitem(req);
    }


    //所有前后端商品信息
    @Test
    public void testAddScitemMap() throws ApiException{
        ScitemMapAddRequest reqSc=new ScitemMapAddRequest();
        reqSc.setItemId(550471303845L);//前端IC商品ID
        reqSc.setScItemId(550440125619L);//后端SC商品ID
        reqSc.setSkuId(3354444973434L);
        reqSc.setOuterCode("hs2017yl");//商家编号hs2016ky
        reqSc.setNeedCheck(false);
        scitemService.addScitemMap(reqSc);
    }

    //查询前后端映射信息
    @Test
    public void queryScitemMap() throws ApiException{
        ScitemMapQueryRequest reqSc=new ScitemMapQueryRequest();
        reqSc.setItemId(550367105833L);//前台IC商品ID
        //reqSc.set
        scitemService.queryScitemMap(reqSc);
    }
}
