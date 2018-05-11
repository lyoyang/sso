package com.lyoyang.sso.service.impl;

import com.lyoyang.entity.User;
import com.lyoyang.service.RegisterService;
import com.lyoyang.sso.dao.UserMapper;
import com.lyoyang.utils.JsonReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserMapper userMapper;

    private static final String SUCCESS = "0";
    private static final String ERROR = "-1";


    @Override
    public JsonReturn checkData(String param, Integer type) {
        if(type == 1){
            User user = userMapper.getByUserName(param);
            if(user != null){
                return JsonReturn.errorInstance("用户名已存在");
            }
        }
        if(type == 2){
            User user = userMapper.getByPhone(param);
            if(user != null){
                return JsonReturn.errorInstance("手机号已存在");
            }
        }
        if(type == 3){
            User user = userMapper.getByEmail(param);
            if(user != null){
                return JsonReturn.errorInstance("邮箱已存在");
            }
        }
        return JsonReturn.successInstance();
    }

    @Override
    public JsonReturn register(User user) {
        if(StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPhone()) || StringUtils.isEmpty(user.getEmail())) {
            return JsonReturn.errorInstance("数据不完整");
        }
        JsonReturn jsonReturn = checkData(user.getUsername(), 1);
        if(jsonReturn.getCode().equals(ERROR)) {
            return JsonReturn.errorInstance("用户名已存在");
        }
        jsonReturn = checkData(user.getPhone(), 2);
        if(jsonReturn.getCode().equals(ERROR)) {
            return JsonReturn.errorInstance("手机号被占用");
        }
        jsonReturn = checkData(user.getEmail(), 3);
        if(jsonReturn.getCode().equals(ERROR)) {
            return JsonReturn.errorInstance("邮箱被占用");
        }
        String md5Pass = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(md5Pass);
        userMapper.insert(user);
        return JsonReturn.successInstance("注册成功");
    }
}
