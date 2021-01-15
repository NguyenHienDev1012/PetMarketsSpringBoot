package com.petmarkets2020.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.petmarkets2020.model.HotPost;
import com.petmarkets2020.service.ListHotPostService;
import com.petmarkets2020.service.ListHotPostService.IHostPost;;

@Controller
public class ListHotPostController {

	@Autowired
	ListHotPostService listhotpostService;

	@GetMapping("getlisthotpost")
	public String getlisthotpost(ModelMap modelMap) {
		listhotpostService.getListHotPost(new IHostPost() {

			@Override
			public void responseData(ArrayList<HotPost> lisHotPosts) {
				modelMap.addAttribute("listhotpost", lisHotPosts);
			}
		});
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "listhotpost";
	}

}
