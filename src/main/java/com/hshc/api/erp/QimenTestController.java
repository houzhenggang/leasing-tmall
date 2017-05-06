package com.hshc.api.erp;

import com.hshc.api.vo.BaseQimenResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 钟林俊
 * @version V1.0 2017-05-06 11:01
 */
@Controller
public class QimenTestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(QimenTestController.class);

    @RequestMapping("/lease-plans")
    @ResponseBody
    public BaseQimenResponseVo syncLeasePlans(@RequestParam("item_id") Integer itemId, @RequestParam("plans") String plans){
        LOGGER.info("itemId:" + itemId);
        LOGGER.info("plans:" + plans);
        return new BaseQimenResponseVo("同步成功!");
    }


}
