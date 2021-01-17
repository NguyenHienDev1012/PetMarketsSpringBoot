package com.petmarkets2020.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.petmarkets2020.model.TransactionHistory;
import com.petmarkets2020.service.TransactionHistoryService;
import com.petmarkets2020.service.TransactionHistoryService.ITransactionHistory;;

@Controller
public class TransactionHistoryController {
	@Autowired
	private TransactionHistoryService historyService;

	@GetMapping("listHistory")
	public String getAllListHistory(Model model) {
		historyService.transactionHistory(new ITransactionHistory() {

			@Override
			public void responseData(HashMap<String, HashMap<String, TransactionHistory>> transactions) {
				model.addAttribute("listHistory", transactions);
			}
		});
		;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "listHistory";
	}

}
