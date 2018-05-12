package com.lyoyang.sso.service.impl;

import com.lyoyang.entity.User;
import com.lyoyang.service.LoginService;
import com.lyoyang.sso.dao.UserMapper;
import com.lyoyang.utils.JedisClient;
import com.lyoyang.utils.JsonReturn;
import com.lyoyang.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;



@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private JedisClient jedisClient;

    @Autowired
    private UserMapper userMapper;

    @Value("${SESSION_EXPIRE}")
    private Integer SESSION_EXPIRE;
    @Override
    public JsonReturn toLogin(String username, String password) {
        User user = userMapper.getByUserName(username);
        if(user == null) {
            return JsonReturn.errorInstance("用户名或密码错误");
        }
        if(!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())) {
            return JsonReturn.errorInstance("用户名或密码错误");
        }
        String token = UUID.randomUUID().toString();
        user.setPassword(null);
        jedisClient.set("SESSION:" + token, JsonUtils.objectToJson(user));
        jedisClient.expire("SESSION:" + token, SESSION_EXPIRE);
        return JsonReturn.successInstance(token);
    }
}
