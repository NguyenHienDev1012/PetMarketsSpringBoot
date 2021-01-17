package com.petmarkets2020.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.petmarkets2020.model.CoinsPackages;
import com.petmarkets2020.service.CoinPackagesServices;

@Controller
public class CoinPackagesController {
	@Autowired
	CoinPackagesServices coinPackagesServices;

	@GetMapping("listcoinpackages")
	public String getCoinPackages(ModelMap modelMap) {

		modelMap.addAttribute("listcoinpackages", coinPackagesServices.getListCoinPackages());
		return "listcoinpackages";

	}

	@GetMapping("deletecoinpackages")
	public String deleteCoinPackage(@RequestParam(required = true) String id, ModelMap modelMap) {
		boolean isDeleted = coinPackagesServices.deleteCoinPackage(id);

		// System.out.println(isDeleted + "Deleted?" + id);
		if (isDeleted) {
			modelMap.addAttribute("deleted", 1);
		} else {
			modelMap.addAttribute("deleted", 0);
		}
		return "redirect:/listcoinpackages";

	}

	@PostMapping("addCoinPackages")
	public String addCoinPackages(CoinsPackages coinsPackages, ModelMap modelMap) {
		coinPackagesServices.addCoinPackages(coinsPackages);
		return "redirect:/listcoinpackages";
	}

	@PostMapping("editCoinPackages")
	public String editCoinPackages(CoinsPackages coinsPackages, ModelMap modelMap) {
		coinPackagesServices.addCoinPackages(coinsPackages);
		return "redirect:/listcoinpackages";
	}

}
