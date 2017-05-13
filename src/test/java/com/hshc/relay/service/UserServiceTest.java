package com.hshc.relay.service;

import com.hshc.relay.BaseTest;
import com.hshc.relay.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 钟林俊
 * @version V1.0 2017-05-09 19:09
 */
public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test(expected = Exception.class)
    public void testRollBack() throws Exception {
        User user = new User();
        user.setName("test");
        user.setIdNumber("123");
        user.setMobile("111");
        user.setPassword("aa");
        User creator = new User();
        creator.setId(1);
        user.setCreator(creator);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        userService.batchAdd1(userList);
    }
}
