package com.petmarkets2020.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.petmarkets2020.model.Rankings;
import com.petmarkets2020.service.RankingsServices;
import com.petmarkets2020.service.RankingsServices.IRankings;

@Controller
public class RankingsController {

	@Autowired
	RankingsServices rankingServices;

	@GetMapping("rankings")
	public String rankings(ModelMap model) {
		rankingServices.rankings(new IRankings() {

			@Override
			public void responseData(HashMap<String, HashMap<String, Rankings>> rankings) {
				model.addAttribute("hmRankings", rankings);
				System.out.println(rankings.size() + "DDDDDDDD");

			}
		});
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "listrankings";
	}

}
