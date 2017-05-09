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

//    @Autowired
//    private ScitemService scitemService;

    @RequestMapping("/lease-scitem")
    @ResponseBody
    @QimenSignAuthentication
    public BaseQimenResponseVo addScitem(@RequestBody ScitemAddRequest scitemAddRequest){
        try{
            ScItem scItem=new ScItem();
            ScitemAddResponse scitemAddResponse=new ScitemAddResponse();
           // scitemService.addScitem(scItem,scitemAddRequest,scitemAddResponse);
        }catch(Exception e){
            System.out.print("发布后端商品："+e);
        }
        return new BaseQimenResponseVo("发布后端商品,查询成功");
    }


}