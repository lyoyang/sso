package com.lyoyang.service;

import com.lyoyang.utils.JsonReturn;

public interface LoginService {

    JsonReturn toLogin(String username, String password);

}
