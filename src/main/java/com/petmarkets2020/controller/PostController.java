package com.petmarkets2020.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.petmarkets2020.service.PostService;

@Controller
public class PostController {
	@Autowired
	private PostService postService;

	@RequestMapping("postList")
	public String postList(Model model) throws InterruptedException, ExecutionException {
		model.addAttribute("postList", postService.getAllPost());
		return "postList";
	}

	@GetMapping("refusePost")
	public String refusePost(@RequestParam String idPost, ModelMap model) {
		postService.refusePost(idPost);
		model.addAttribute("message", "Post has been removed.");
		return "redirect:/postList";

	}

	@GetMapping("approvedPost")
	public String approvedPost(@RequestParam String idPost, ModelMap model) {
		postService.approvedPost(idPost);
		model.addAttribute("message", "Post has been approved.");
		return "redirect:/postList";

	}

}
