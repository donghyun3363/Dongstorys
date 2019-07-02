package com.dong.springboot.controller;

import java.util.Arrays;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dong.springboot.service.PostsService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebController {

	private PostsService postsService;

	
	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("posts", postsService.findAllDesc());
		System.out.println("model: " + model + ", " + model.toString());
		return "main";
	}

	@ResponseBody
	@GetMapping("/list")
	public String test(Model model) {

		String values;
		values = "{\"1\":\"saaaaa\", \"2\", \"bbbbb\"}";
		return values;
	}
	

	
}