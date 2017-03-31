package com.xcesys.extras.web.controller;

import static com.xcesys.extras.framework.core.util.SecurityUtils.isSwitchedUser;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.xcesys.extras.framework.core.controller.BaseController;

@Controller
public class HomeController extends BaseController {

	public static final int MINUTES = 60;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping(value = "/login/fail")
	public String loginFailure(Model model) {
		String message = "Wrong password or username provided! Please try again.";
		model.addAttribute("message", message);
		return "login";
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
		return "switchuser";
	}

	@GetMapping("/switchuserto{username}")
	public String switchUserUsername(@PathVariable String username) {
		return "redirect:/switchuserto?username=" + username;
	}

	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}

}
