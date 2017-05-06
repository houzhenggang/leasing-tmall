package com.hshc.relay.controller.erp;


import com.hshc.relay.vo.BaseQimenResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品库存信息
 * @author  王华英
 * @version  v1.0 2017年5月6日14:50:49
 */
@Controller
public class InventoryController {

    private static final Logger LOGGER= LoggerFactory.getLogger(InventoryController.class);
    /**
     * 商家查询商品总体库存信息
     */
    @RequestMapping("/lease-inventory")
    @ResponseBody
    public BaseQimenResponseVo queryInventory(@RequestParam("sc_item_ids")String scItemIds){
        LOGGER.info("scItemIds:"+scItemIds);
        return new BaseQimenResponseVo("查询成功");
    }

}
