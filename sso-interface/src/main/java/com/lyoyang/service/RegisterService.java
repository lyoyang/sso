package com.lyoyang.service;

import com.lyoyang.entity.User;
import com.lyoyang.utils.JsonReturn;

public interface RegisterService {
    JsonReturn checkData(String param, Integer type);
    JsonReturn register(User user);
}
