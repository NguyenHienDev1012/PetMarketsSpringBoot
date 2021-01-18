package com.petmarkets2020.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.petmarkets2020.service.TransactionHistoryService;

@Controller
public class TransactionHistoryController {
	@Autowired
	private TransactionHistoryService historyService;

	@GetMapping("listHistory")
	public String getAllListHistory(Model model) throws InterruptedException {
		model.addAttribute("listHistory", historyService.getAllTransactionHistory());
		return "listHistory";
	}
}
