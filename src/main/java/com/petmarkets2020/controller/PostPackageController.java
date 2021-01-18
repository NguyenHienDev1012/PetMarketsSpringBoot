package com.petmarkets2020.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.petmarkets2020.service.PostPackageService;

@Controller
public class PostPackageController {
	@Autowired
	private PostPackageService service;
	
	@GetMapping("listPostPackage")
	public String getAllPostPackage(Model model) throws InterruptedException {
		model.addAttribute("listPostPackage", service.getAllPostPackage());
		return "listPostPackage";
	}
}
