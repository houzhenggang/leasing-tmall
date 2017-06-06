package com.hshc.relay.controller;

import com.hshc.relay.dto.Page;
import com.hshc.relay.entity.User;
import com.hshc.relay.exception.BaseException;
import com.hshc.relay.service.UserService;
import com.hshc.relay.vo.BaseResponseVo;
import com.hshc.relay.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author 钟林俊
 * @version V1.0 2017-05-01 15:34
 */
@RestController
public class UserController extends BaseController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public PageVo getUserPage(@RequestBody Page<User> page){
        Page<User> userPage = userService.getPage(page);
        return PageVo.success(userPage);
    }

    /**
     * form表单提交的参数 格式param1=value1&param2=value2
     *
     * @param user 入参封装为对象 @Valid注解 可以用来验证入参，打开User类查看注解验证
     * @return json格式响应字符串 @ResponseBody 使用FastJson将对象转换为json格式的字符串
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public BaseResponseVo addUser(@Valid User user){
        userService.add(user);
        return BaseResponseVo.success();
    }

    /**
     * restful风格的url,对url的简化可以体会一下，对比下面delUser的方法
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Integer id){
        User user = new User();
        user.setId(id);
        return userService.getOne(user);
    }

    /**
     * json格式的入参{"param1": value1, "param2": value2},请对比addUser的方法，注意入参格式的不同都可以封装成为需要的对象
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public BaseResponseVo modUser(@RequestBody User user){
        if(userService.modify(user) > 0){
            BaseResponseVo responseVo = new BaseResponseVo();
            responseVo.setCode("200");
            responseVo.setMessage("修改成功！");
            return responseVo;
        }
        throw new BaseException("500", "修改失败！");
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public BaseResponseVo delUser(@PathVariable Integer id){
        userService.remove(id);
        BaseResponseVo responseVo = new BaseResponseVo();
        responseVo.setCode("200");
        responseVo.setMessage("删除成功！");
        return responseVo;
    }

}
