package com.thoughtworks.toc.account.controller;

import com.thoughtworks.toc.account.model.User;
import com.thoughtworks.toc.account.repository.UserRepository;
import com.thoughtworks.toc.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ApiController {

	@Autowired
    UserService userService;

	@Autowired
	UserRepository userR;

    @RequestMapping(value = "/user", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,Object>  user() {
		return responseInfo(1, "Ok!", userR.findAll());
    }

    @RequestMapping(value = "/useredit", method = {RequestMethod.POST }, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,Object>  useredit(@RequestParam("userid") Long userid,@RequestParam("username") String username,@RequestParam("email") String email,@RequestParam("age") Integer age) {

    	userR.save(new User(userid,username,email,age));
    	return responseInfo(1, "Update success!", "");
    }

    @RequestMapping(value = "/userdel", method = {RequestMethod.POST }, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,Object>  userdel(@RequestParam("userid") Long userid) {

    	userR.delete(userid);
    	return responseInfo(1, "Del success!", "");
    }

    @RequestMapping(value = "/usersearch", method = {RequestMethod.GET }, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,Object>  usersearch(@RequestParam("username") String username) {

    	List<User> users = userR.findByUsername(username);
        return responseInfo(1, "Add success!", users);
    }

    @RequestMapping(value = "/useradd", method = {RequestMethod.POST }, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,Object>  useradd(@RequestParam("username") String username,@RequestParam("email") String email,@RequestParam("age") Integer age) {

    	userR.save(new User(username,email,age));
		return responseInfo(1, "Add success!", new HashMap());
    }

    private Map<String,Object> responseInfo(Integer status, String msg, java.lang.Object data) {

		Map<String,Object> map  = new HashMap<>();
		map.put("status", status);
		map.put("message", msg);
		map.put("data", data);
		return map;
	}

    /* Test
    @RequestMapping(value = "/say/{msg}", produces = "application/json;charset=UTF-8")
	public @ResponseBody
	String say(@PathVariable(value = "msg") String msg) {
		return "{\"msg\":\"you say:'" + msg + "'\"}";
	}

    @RequestMapping(value="/validataUser/{t}")
    @ResponseBody
    public Map<String,Object> validataUser(@PathVariable String t){
        //logger.info(" validata user : {}",userName);
    	//System.out.println(userService.findByUsername(t));
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code", true);
        return map;
    }

    @RequestMapping(value = "/api/login/{id}", produces = "application/json;charset=UTF-8")
    public @ResponseBody
    String api(@PathVariable String id) {
        return id;
    }

    @RequestMapping(value = "/users", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,Object>  users() {
    	Map<String,Object> map = new HashMap<String,Object>();

    	List<User> users = userService.getAllUsers();

    	int i = 0;
    	for (User user : users) {
            System.out.println(user.getUsername());
            map.put("user"+i, user.getUsername());
            i++;
        }
    	map.put("xxxxx", userR.findOne(1L));
    	return map;
    }
    */
}
