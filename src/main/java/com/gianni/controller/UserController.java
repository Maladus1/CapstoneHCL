package com.gianni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gianni.Entities.User;
import com.gianni.Service.UserService;
import com.gianni.email.SendEmail;

@RestController
public class UserController
{
	@Autowired
	private UserService service;
	
	@PostMapping("/signup")
	public String addNewUser(@RequestBody User u)
	{
		u.setUsername(u.getUsername());
		u.setPassword(u.getPassword());
		u.setEmail(u.getEmail());
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(u.getPassword());
		u.setPassword(encodedPassword);
		
		service.addUser(u);
		service.assignRoletoUser(u, "admin");
		
		SendEmail email = new SendEmail();
		email.sendMail(u.getEmail(), u.getUsername());
		
		return ("<h1>You Have Signed Up</h1>");
	}
}
