package com.petmarkets2020.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petmarkets2020.service.UsersModelServices;

@Controller
public class UsersModelController {
	@Autowired
	UsersModelServices modelServices;
	
	@RequestMapping("/userList")
	public String userList(Model model) throws InterruptedException, ExecutionException {
		model.addAttribute("userList", modelServices.getListUser());
		return "userList";
	}
}
