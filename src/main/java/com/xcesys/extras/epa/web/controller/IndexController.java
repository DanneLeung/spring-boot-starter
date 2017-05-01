package com.xcesys.extras.epa.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IndexController {

	@GetMapping("/")
	public String index() {
		return "EPA API HOME";
	}
}
