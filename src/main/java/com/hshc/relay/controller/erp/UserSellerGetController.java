package com.hshc.relay.controller.erp;

import com.hshc.relay.controller.BaseController;
import com.hshc.relay.service.UserSellerGetService;
import com.taobao.api.ApiException;
import com.taobao.api.request.UserSellerGetRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品库存信息
 * @author  王华英
 * @version  v1.0 2017年5月12日14:50:49
 */
@Controller
public class UserSellerGetController extends BaseController{

    @Autowired
    private UserSellerGetService userSellerGetService;

    @RequestMapping("/get-userseller")
    @ResponseBody
    public void getUserSeller(UserSellerGetRequest reqSc)throws ApiException{
        userSellerGetService.getUserSeller(reqSc);
    }

}
