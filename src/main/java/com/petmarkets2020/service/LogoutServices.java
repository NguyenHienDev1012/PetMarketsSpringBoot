package com.petmarkets2020.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class LogoutServices {
	public void logout(HttpSession session) {
		session.removeAttribute("fullname");

	}

}
