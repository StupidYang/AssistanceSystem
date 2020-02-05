package com.example.assistancesystem.controller;

import com.example.assistancesystem.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

    //private static Logger log = LoggerFactory.getLogger(RegisterController.class);

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public ModelAndView toRegister(){
        User user = new User();
        return new ModelAndView("register").addObject(user);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute(value = "user") User user){
        //log.info(user.getUsername());
        return new ModelAndView("register");
    }
}
