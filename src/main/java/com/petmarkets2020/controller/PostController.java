package com.petmarkets2020.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.petmarkets2020.model.PostModel;
import com.petmarkets2020.service.PostService;
import com.petmarkets2020.service.PostService.IPosts;;

@Controller
public class PostController {
	@Autowired
	private PostService postService;

	@RequestMapping("postList")
	public String postList(Model model) throws InterruptedException, ExecutionException {
		postService.getAllPost(new IPosts() {

			@Override
			public void responseData(List<PostModel> listPosts) {
				model.addAttribute("postList", listPosts);
			}
		});
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "postList";
	}

	@GetMapping("refusePost")
	public String refusePost(@RequestParam String idPost, ModelMap model) {
		postService.refusePost(idPost);

		model.addAttribute("refusePost", "Post has been removed.");
		return "redirect:/postList";

	}

	@GetMapping("approvedPost")
	public String approvedPost(@RequestParam String idPost, ModelMap model) {
		postService.approvedPost(idPost);
		model.addAttribute("approvedPost", "Post has been approved.");
		return "redirect:/postList";

	}

}
