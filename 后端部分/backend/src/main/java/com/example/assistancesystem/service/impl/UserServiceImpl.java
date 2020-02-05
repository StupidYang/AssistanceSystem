package com.example.assistancesystem.service.impl;

import com.example.assistancesystem.model.User;
import com.example.assistancesystem.repository.UserRepository;
import com.example.assistancesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public User Regist(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User getUser(String username) {
        return userRepository.getOne(username);
    }
}
