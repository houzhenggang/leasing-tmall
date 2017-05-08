package com.hshc.relay.controller.erp;

import com.hshc.relay.annotation.QimenSignAuthentication;
import com.hshc.relay.controller.BaseController;
import com.hshc.relay.service.ScitemService;
import com.hshc.relay.vo.BaseQimenResponseVo;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.ScItem;
import com.taobao.api.request.ScitemAddRequest;
import com.taobao.api.response.ScitemAddResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.hshc.relay.service.RequestTaobaoService.*;

/**
 * 发布后端商品
 * @author 王华英
 * @version V1.0 2017年5月6日16:54:25
 */
@Controller
public class ScitemController extends BaseController{
    private static Logger LOGGER = LoggerFactory.getLogger(ScitemController.class);

    @Autowired
    private ScitemService scitemService;

    @RequestMapping("/lease-scitem")
    @ResponseBody
    @QimenSignAuthentication
    public BaseQimenResponseVo addScitem(@RequestBody ScitemAddRequest req){
        try{
            req.setItemName("宝贝");
            req.setOuterCode("商家编码");
            req.setItemType(0L);
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
            req.setIsAreaSale(1L);
            ScitemAddResponse rep=new ScitemAddResponse();
            scitemService.addScitem(req);
        }catch(Exception e){
            System.out.print("发布后端商品："+e);
        }
        return new BaseQimenResponseVo("发布后端商品,查询成功");
    }


}
