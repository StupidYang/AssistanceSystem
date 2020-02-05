package com.example.assistancesystem.service;

import com.example.assistancesystem.model.User;

public interface UserService {
//  注册
    public User Regist(User user);
//  找到用户，并获取全部信息
    public User getUser(String username);
}
