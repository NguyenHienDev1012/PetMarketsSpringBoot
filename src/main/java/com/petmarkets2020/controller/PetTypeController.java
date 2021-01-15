package com.petmarkets2020.controller;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petmarkets2020.model.PetType;
import com.petmarkets2020.service.PetTypeServices;
import com.petmarkets2020.service.PetTypeServices.IPetType;

@Controller
public class PetTypeController {
	@Autowired
	PetTypeServices petTypeServices;

	@RequestMapping("listPetType")
	public String getAllPetType(ModelMap model) throws IOException {
		petTypeServices.getAll(new IPetType() {

			@Override
			public void responseData(HashMap<String, HashMap<String, PetType>> thm) {
				model.addAttribute("listPetType", thm);
			}
		});
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "listPetType";
	}

}
