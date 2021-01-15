package com.petmarkets2020.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petmarkets2020.model.UsersModel;
import com.petmarkets2020.service.UsersModelServices;
import com.petmarkets2020.service.UsersModelServices.IUsers;

@Controller
public class UsersModelController {
	@Autowired
	UsersModelServices modelServices;

	@RequestMapping("/userList")
	public String userList(Model model) throws InterruptedException, ExecutionException {
		modelServices.getListUser(new IUsers() {

			@Override
			public void responseData(List<UsersModel> listUsers) {
				model.addAttribute("userList", listUsers);
			}
		});
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "userList";
	}
}
