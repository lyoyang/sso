package com.lyoyang.sso.service.impl;

import com.lyoyang.entity.User;
import com.lyoyang.service.TokenService;
import com.lyoyang.utils.JedisClient;
import com.lyoyang.utils.JsonReturn;
import com.lyoyang.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class TokenServiceImpl implements TokenService {


    @Autowired
    private JedisClient jedisClient;

    @Value("${SESSION_EXPIRE}")
    private Integer SESSION_EXPIRE;

    @Override
    public JsonReturn getUserByToken(String token) {
        String json = jedisClient.get("SESSION:" + token);
        if(StringUtils.isEmpty(json)) {
            return JsonReturn.createSuccessResult("201","用户登录过期，请重新登录");
        }
        jedisClient.expire("SESSION:" + token, SESSION_EXPIRE);
        return JsonReturn.successInstance(JsonUtils.jsonToPojo(json, User.class));
    }
}
