package com.example.assistancesystem.controller.api;

import com.example.assistancesystem.base.controller.BaseApiController;
import com.example.assistancesystem.base.result.Result;
import com.example.assistancesystem.base.result.ResultCode;
import com.example.assistancesystem.model.User;
import com.example.assistancesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginApiController extends BaseApiController {

    @Autowired
    public UserService userService;

    @ResponseBody
    @RequestMapping(value = "/login")
    public Result<Object> login(@ModelAttribute(value = "user") @Valid User user, BindingResult bindingResult, HttpSession session){
        if(bindingResult.hasErrors()){
            return Result.failure();
        }

        User dbUser = userService.getUser(user.getUsername());

        if(dbUser != null){
            if(dbUser.getPassword().equals(user.getPassword())){
                session.setAttribute("user",user);
                return Result.success();
            }else {
                return Result.failure(ResultCode.USER_LOGIN_ERROR);
            }
        }else {
            return Result.failure(ResultCode.USER_LOGIN_ERROR);
        }
    }
}
