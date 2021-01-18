package com.petmarkets2020.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.petmarkets2020.service.ListHotPostService;

@Controller
public class ListHotPostController {

	@Autowired
	ListHotPostService listhotpostService;

	@GetMapping("getlisthotpost")
	public String getlisthotpost(ModelMap modelMap) throws InterruptedException {
		System.out.println(listhotpostService.getListHotPost().toString());
		modelMap.addAttribute("listhotpost", listhotpostService.getListHotPost());
		return "listhotpost";
	}

}
