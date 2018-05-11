package com.lyoyang.service;

import com.lyoyang.utils.JsonReturn;

public interface TokenService {
    JsonReturn getUserByToken(String tiken);
}
