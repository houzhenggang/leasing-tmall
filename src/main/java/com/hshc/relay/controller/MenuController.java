package com.hshc.relay.controller;

import com.hshc.relay.entity.Menu;
import com.hshc.relay.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 钟林俊
 * @version V1.0 2017-06-08 15:47
 */
@RestController
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/menus", method = RequestMethod.GET)
    public List<Menu> getMenus(){
        return menuService.getList(null);
    }

}
