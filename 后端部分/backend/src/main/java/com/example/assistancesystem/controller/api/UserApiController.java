package com.example.assistancesystem.controller.api;

import com.example.assistancesystem.base.controller.BaseApiController;
import com.example.assistancesystem.base.result.Result;
import com.example.assistancesystem.model.User;
import com.example.assistancesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.example.assistancesystem.base.result.ResultCode.USER_NOT_FOUND;

@Controller
public class UserApiController extends BaseApiController {

    @Autowired
    public UserService userService;

    @ResponseBody
    @RequestMapping(value = "/getUserInformation")
    public String getUserInformation(@ModelAttribute(value = "user") @Valid User user, HttpSession session){
//      把某人的信息传递给前端
        User dbUser = userService.getUser(user.getUsername());
        if(dbUser == null){
            return Result.failure(USER_NOT_FOUND).getMessage();
        }
        String userInformation = "{uid:'"+ dbUser.getUid() +"'," +
                                 "name:'"+ dbUser.getName() +"',"+
                                 "department:'"+ dbUser.getDepartment() +"',"+
                                 "post:'"+ dbUser.getPost() +"',"+
                                 "classes:'"+ dbUser.getClasses() +"',"+
                                 "tel:'"+ dbUser.getTel() +"',"+
                                 "qq:'"+ dbUser.getQq() +"',"+
                                 "num:'"+ dbUser.getNum() +"',"+
                                 "power:'"+ dbUser.getPower() +"'}";
        return userInformation;
    }
}
