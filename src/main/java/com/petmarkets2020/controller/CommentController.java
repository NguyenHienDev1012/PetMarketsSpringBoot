package com.petmarkets2020.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.petmarkets2020.model.Comments;
import com.petmarkets2020.service.CommentServices;

@Controller
public class CommentController {
	
	@Autowired
	CommentServices commentServices;

	@GetMapping("/getCommentDetails")
	public String getComments(@RequestParam String cmtId, ModelMap modelMap) throws InterruptedException, ExecutionException {
		modelMap.addAttribute("comment", commentServices.getComments(cmtId));
		System.out.println(cmtId);
		return "commentdetails";
		
	}
	
	@GetMapping("/getlistComments")
	public String getlistComments(ModelMap modelMap) throws InterruptedException, ExecutionException {
		modelMap.addAttribute("listcomments", commentServices.getlistComments());
		return "listcomments";
		
	}
}
