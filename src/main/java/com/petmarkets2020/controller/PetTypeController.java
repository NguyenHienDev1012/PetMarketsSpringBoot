package com.petmarkets2020.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petmarkets2020.service.PetTypeServices;

@Controller
public class PetTypeController {
	@Autowired
	PetTypeServices petTypeServices;

	@RequestMapping("listPetType")
	public String getAllPetType(ModelMap model) throws IOException {
		model.addAttribute("listPetType", petTypeServices.getAll());
		return "listPetType";
	}

}
