package com.petmarkets2020.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petmarkets2020.model.PetType;
import com.petmarkets2020.service.PetTypeServices;

@Controller
public class PetTypeController {
	@Autowired
	PetTypeServices petTypeServices;

	@RequestMapping("listPetType")
	public String getAllPetType(ModelMap model) {
		HashMap<String, HashMap<String, PetType>> thm = petTypeServices.getAll();
		model.addAttribute("listPetType", thm);
		return "listPetType";
	}

}
