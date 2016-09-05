package com.thoughtworks.toc.account;

import com.thoughtworks.toc.account.model.User;
import com.thoughtworks.toc.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    
	@Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login() {
    	System.out.println("hello /login!");
        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome() {
        return "welcome";
    }
}
