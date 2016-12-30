package com.thoughtworks.toc.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {


	@ResponseBody
	@RequestMapping(value="/login/{userName}/{pwd}")
	public String login(@PathVariable("userName") String userName, @PathVariable("pwd") String pwd) {

		String result;

		if(userName.equals("admin") && pwd.equals("admin")){
			result = "true";
		}else{
			result = "false";
		}
		return result;
	}
}
