package com.petmarkets2020.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.petmarkets2020.model.LoginModel;
import com.petmarkets2020.model.UsersModel;
import com.petmarkets2020.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;

	@GetMapping(value = {"/","/login"})
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String loginProcess(LoginModel loginModel, HttpSession session) {
		System.out.println(loginModel.getUid() + "//" + loginModel.getPassword());

		UsersModel usersModel = loginService.checkLogin(loginModel.getUid(), loginModel.getPassword());
		if (usersModel != null) {
			session.setAttribute("fullname", usersModel.getUid());
			return "redirect:/dashboard";
		}
		return "login";

	}

}
