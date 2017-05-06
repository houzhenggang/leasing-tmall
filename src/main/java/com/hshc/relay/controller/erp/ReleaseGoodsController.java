package com.hshc.relay.controller.erp;

import com.hshc.relay.vo.BaseQimenResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 创建IC商品与后端商品的映射关系
 * @author 王华英
 * @version V1.0 2017年5月6日16:54:25
 */
@Controller
public class ReleaseGoodsController {
    private static Logger LOGGER= LoggerFactory.getLogger(ReleaseGoodsController.class);

    @RequestMapping("/lease-releasegoods")
    @ResponseBody
    public BaseQimenResponseVo addReleaseGoods(@RequestParam("item_id")Integer itemId){
        LOGGER.info("itemId:"+itemId);
        return new BaseQimenResponseVo("查询成功");
    }


}
