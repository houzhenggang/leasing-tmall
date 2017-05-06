package com.hshc.relay.controller.erp;

import com.hshc.relay.vo.BaseQimenResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 发布后端商品
 * @author 王华英
 * @version V1.0 2017年5月6日16:54:25
 */
@Controller
public class ReleaseGoodsController {
    private static Logger LOGGER = LoggerFactory.getLogger(ReleaseGoodsController.class);

    @RequestMapping("/lease-releaseGoods")
    @ResponseBody
    public BaseQimenResponseVo addReleaseGoods(@RequestParam("item_name")String itemName ,@RequestParam("outer_code")String outerCode ){
        LOGGER.info("itemName:"+itemName);
        LOGGER.info("outerCode:"+outerCode);
        return new BaseQimenResponseVo("查询成功");
    }


}
