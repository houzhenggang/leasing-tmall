package com.hshc.relay.controller;

import com.hshc.relay.entity.User;
import com.hshc.relay.exception.BaseException;
import com.hshc.relay.service.UserService;
import com.hshc.relay.vo.BaseResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 钟林俊
 * @version V1.0 2017-05-01 15:34
 */
@Controller
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<String> addUser(User user){
        userService.add(user);
        BaseResponseVo responseVo = new BaseResponseVo();
        responseVo.setCode("200");
        responseVo.setMessage("新增成功！");
        return response(responseVo);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getUser(@PathVariable Integer id){
        User user = new User();
        user.setId(id);
        return response(userService.getOne(user));
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public ResponseEntity<String> modUser(User user){
        if(userService.modify(user) > 0){
            BaseResponseVo responseVo = new BaseResponseVo();
            responseVo.setCode("200");
            responseVo.setMessage("修改成功！");
            return response(responseVo);
        }
        throw new BaseException("500", "修改失败！");
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delUser(@PathVariable Integer id){
        userService.remove(id);
        BaseResponseVo responseVo = new BaseResponseVo();
        responseVo.setCode("200");
        responseVo.setMessage("删除成功！");
        return response(responseVo);
    }

}
