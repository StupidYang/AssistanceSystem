package com.example.assistancesystem.service;

import com.example.assistancesystem.model.User;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.fail;

@SpringBootTest
class UserServiceTest {

    @Autowired
    public UserService userService;

    @Test
    public void test(){
        User user = new User("test","test");
        //User newuser = save(user);
        TestCase.assertNotNull(userService.Regist(user));
    }
}