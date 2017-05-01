package com.xcesys.extras.web.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	public static final int MINUTES = 60;

	@GetMapping("/")
	public String welcome(Map<String, Object> model) {
		return "index";
	}
}