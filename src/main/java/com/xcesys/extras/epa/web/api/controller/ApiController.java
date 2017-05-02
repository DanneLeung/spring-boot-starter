package com.xcesys.extras.epa.web.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API Index")
@RestController
@RequestMapping("/api")
public class ApiController {
	@ApiOperation("index")
	@GetMapping("/")
	public String index() {
		return "EPA API HOME";
	}
}
