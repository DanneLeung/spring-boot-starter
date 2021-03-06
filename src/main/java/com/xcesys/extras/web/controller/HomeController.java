package com.xcesys.extras.web.controller;

import static com.xcesys.extras.framework.core.util.SecurityUtils.isSwitchedUser;

import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

	public static final int MINUTES = 60;

	@GetMapping("/login")
	public String login() {
		return "pages/login";
	}

	@GetMapping(value = "/login/fail")
	public String loginFailure(Model model) {
		String message = "Wrong password or username provided! Please try again.";
		model.addAttribute("message", message);
		return "pages/login";
	}

	@GetMapping(value = "/login/success")
	public String loginSuccess() {
		return "redirect:/";
	}

	@GetMapping(value = "/logout/success")
	public String logoutSuccess() {
		return "redirect:/";
	}

	@GetMapping("/logout")
	public String logoutSwitchedUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (isSwitchedUser()) {
			return "redirect:/switchuserlogout";
		}

		return "redirect:/logout";
	}

	@GetMapping("/switchuser")
	public String switchUser() {
		return "pages/switchuser";
	}

	@GetMapping("/switchuserto{username}")
	public String switchUserUsername(@PathVariable String username) {
		return "redirect:/switchuserto?username=" + username;
	}

	@GetMapping("/")
	public String welcome(Map<String, Object> model) {
		return "pages/index";
	}

}
