package com.hshc.relay.controller;

import com.hshc.relay.dto.PageRequest;
import com.hshc.relay.dto.qo.MessageQo;
import com.hshc.relay.service.MessageService;
import com.hshc.relay.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 钟林俊
 * @version V1.0 2017-06-14 14:48
 */
@RestController
public class MessageController extends BaseController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    public PageVo getMessages(@RequestBody PageRequest<MessageQo> pageRequest){
        return PageVo.success(messageService.getPage(pageRequest));
    }

}
