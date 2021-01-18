package com.petmarkets2020.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.petmarkets2020.service.RankingsServices;

@Controller
public class RankingsController {

	@Autowired
	RankingsServices rankingServices;

	@GetMapping("rankings")
	public String rankings(ModelMap model) throws InterruptedException {

		model.addAttribute("hmRankings", rankingServices.getAllRankings());
		return "listrankings";
	}
}
