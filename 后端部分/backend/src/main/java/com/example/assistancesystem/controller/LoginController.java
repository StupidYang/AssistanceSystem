package com.example.assistancesystem.controller;

import com.example.assistancesystem.model.User;
import com.example.assistancesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("user",new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute(value = "user") @Valid User user, BindingResult bindingResult, HttpSession session){
        if(bindingResult.hasErrors()){
            return "login";
        }

        User dbUser = userService.getUser(user.getUsername());

        if(dbUser != null){
            if(dbUser.getPassword().equals(user.getPassword())){
                session.setAttribute("user",user);
                return "home";
            }else {
                return "login";
            }
        }else {
            return "login";
        }
    }
}
