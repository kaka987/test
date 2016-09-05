package com.thoughtworks.toc.account.controller;

import com.thoughtworks.toc.account.model.User;
import com.thoughtworks.toc.account.service.UserService;
import com.thoughtworks.toc.account.repository.*;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApiController {
	
	@Autowired
    UserService userService;
	
	@Autowired
	UserRepository userR;
    
    @RequestMapping(value = "/user", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,Object>  user() {
    	Map<String,Object> map  = new HashMap<String,Object>(); 
    	Map<Integer,Object> map1 = new HashMap<Integer,Object>();
   
    	int i = 0;
    	for (User user : userR.findAll()) {
    		Map<String,Object> map2  = new HashMap<String,Object>();
    		map2.put("id", user.getId());
    		map2.put("username", user.getUsername());
    		map2.put("age", user.getAge());
    		map2.put("email", user.getEmail());
    		map1.put(i, map2);
            i++;
        }
    	map.put("status", 1);
    	map.put("message", "ok");
    	map.put("data", map1);
    	
    	return map;
    }
    
    @RequestMapping(value = "/useredit", method = {RequestMethod.POST }, produces = "application/json;charset=UTF-8") 
    @ResponseBody
    public Map<String,Object>  useredit(@RequestParam("userid") Long userid,@RequestParam("username") String username,@RequestParam("email") String email,@RequestParam("age") Integer age) {
    	
    	userR.save(new User(userid,username,email,age));
    	
    	Map<String,Object> map  = new HashMap<String,Object>(); 
    	map.put("status", 1);
    	map.put("message", "Update success!");
    	map.put("data", "");
    	
    	return map;
    }
    
    @RequestMapping(value = "/userdel", method = {RequestMethod.POST }, produces = "application/json;charset=UTF-8") 
    @ResponseBody
    public Map<String,Object>  userdel(@RequestParam("userid") Long userid) {
    	
    	Map<String,Object> map  = new HashMap<String,Object>(); 
    	
    	userR.delete(userid);
    	map.put("status", 1);
    	map.put("message", "Del success!");
    	map.put("data", "");
    	
    	return map;
    }
    
    @RequestMapping(value = "/usersearch", method = {RequestMethod.GET }, produces = "application/json;charset=UTF-8") 
    @ResponseBody
    public Map<String,Object>  usersearch(@RequestParam("username") String username) {
    	
    	Map<String,Object> map  = new HashMap<String,Object>(); 
    	
    	List<User> users = userR.findByUsername(username);
    	
    	map.put("status", 1);
    	map.put("message", "Add success!");
    	map.put("data", users);
    	
    	return map;
    }
    
    @RequestMapping(value = "/useradd", method = {RequestMethod.POST }, produces = "application/json;charset=UTF-8") 
    @ResponseBody
    public Map<String,Object>  useradd(@RequestParam("username") String username,@RequestParam("email") String email,@RequestParam("age") Integer age) {
    	
    	Map<String,Object> map  = new HashMap<String,Object>(); 
    	
    	userR.save(new User(username,email,age));
    	map.put("status", 1);
    	map.put("message", "Add success!");
    	map.put("data", "");
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
