package com.hshc.relay.controller.erp;

import com.hshc.relay.annotation.QimenSignAuthentication;
import com.hshc.relay.controller.BaseController;
import com.hshc.relay.vo.BaseResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 创建IC商品与后端商品的映射关系
 * @author  王华英
 * @version  V1.0 2017年5月6日17:14:48
 */
@Controller
public class AssociatedController extends BaseController{

    @RequestMapping("/lease-associat")
    @ResponseBody
    @QimenSignAuthentication
    public BaseResponseVo addAssociated(@RequestParam("item_id")Integer itemId ){
        logger.info("itemId:" + itemId);
        //业务逻辑
        //处理
        return new BaseResponseVo("创建IC商品与后端商品的映射关系,查询成功");
    }

}
