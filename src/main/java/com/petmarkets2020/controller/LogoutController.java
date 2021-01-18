package com.petmarkets2020.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.petmarkets2020.service.LogoutServices;

@Controller
public class LogoutController {
	
	@Autowired
	LogoutServices logoutservices;
	@GetMapping("logout")
	public String logout(HttpSession session) throws InterruptedException {
	    logoutservices.logout(session);
		return "login";
		
	}

}
