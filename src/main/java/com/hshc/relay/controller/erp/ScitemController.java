package com.hshc.relay.controller.erp;

import com.hshc.relay.annotation.QimenSignAuthentication;
import com.hshc.relay.controller.BaseController;
import com.hshc.relay.vo.BaseQimenResponseVo;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.ScitemAddRequest;
import com.taobao.api.response.ScitemAddResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.hshc.relay.service.RequestTaobaoClient.*;

/**
 * 发布后端商品
 * @author 王华英
 * @version V1.0 2017年5月6日16:54:25
 */
@Controller
public class ScitemController extends BaseController{
    private static Logger LOGGER = LoggerFactory.getLogger(ScitemController.class);

    @RequestMapping("/lease-scitem")
    @ResponseBody
    @QimenSignAuthentication
    public BaseQimenResponseVo addScitem(@RequestBody ScitemAddRequest req){
        try{
            //LOGGER.info("itemName:"+itemName);
            //LOGGER.info("outerCode:"+outerCode);
           /* TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
            ScitemAddRequest req1 = new ScitemAddRequest();
            req1.setItemName("宝贝");
            req1.setOuterCode("商家编码");
            req1.setItemType(0L);
            req1.setProperties("111:222;333:444");
            req1.setBarCode("条形码");
            req1.setWmsCode("仓储商编码");
            req1.setIsFriable(0L);
            req1.setIsDangerous(0L);
            req1.setIsCostly(0L);
            req1.setIsWarranty(0L);
            req1.setWeight(1L);
            req1.setLength(1L);
            req1.setWidth(1L);
            req1.setHeight(1L);
            req1.setVolume(1L);
            req1.setPrice(1L);
            req1.setRemark("remark");
            req1.setMatterStatus(0L);
            req1.setBrandId(1L);
            req1.setBrandName("brand_Name");
            req1.setSpuId(1234L);
            req1.setIsAreaSale(1L);
            ScitemAddResponse rsp = client.execute(req, sessionKey);
            System.out.println(rsp.getBody());*/
            System.out.print(req);
            //业务逻辑
            //处理
        }catch(Exception e){
            System.out.print("发布后端商品："+e);
        }

        return new BaseQimenResponseVo("发布后端商品,查询成功");
    }


}
