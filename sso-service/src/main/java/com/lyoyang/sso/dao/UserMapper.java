package com.lyoyang.sso.dao;


import com.lyoyang.entity.User;

public interface UserMapper {

    User getByUserName(String username);

    User getByPhone(String phone);

    User getByEmail(String email);

    void insert(User user);

}
