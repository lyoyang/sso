package com.lyoyang.dao.test;

import com.lyoyang.BaseTest;
import com.lyoyang.entity.User;
import com.lyoyang.sso.dao.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class UserDaoTest extends BaseTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void getUserByName() throws IOException {
        User user = userMapper.getByUserName("jim");
        System.out.println(user.getUsername() + "----<<<<<<");
        System.in.read();
    }

}
