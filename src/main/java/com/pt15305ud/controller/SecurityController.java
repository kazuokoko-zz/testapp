package com.pt15305ud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security")
public class SecurityController {

	@RequestMapping("/login/form")
	public String loginForm(Model model) {
		model.addAttribute("message", "Vui lòng đăng nhập");
		model.addAttribute("mess-bg", -1);
		return "security/login";
	}

	@RequestMapping("/login/success")
	public String loginSuccess(Model model) {
		model.addAttribute("message", "Đăng nhập thành công");
		model.addAttribute("mess-bg", 1);
		return "security/login";
	}

	@RequestMapping("/login/error")
	public String loginError(Model model) {
		model.addAttribute("message", "Sai tên đăng nhập hoặc mật khẩu");
		model.addAttribute("mess-bg", 0);
		return "security/login";
	}

	@RequestMapping("/unauthoried")
	public String unauthoried(Model model) {
		model.addAttribute("message", "không có quyền truy cập");
		model.addAttribute("mess-bg", 0);
		return "security/login";
	}
	
	@RequestMapping("/logout/success")
	public String logoutSuccess(Model model) {
		model.addAttribute("message", "Đã đăng xuất");
		model.addAttribute("mess-bg", 1);
		return "security/login";
	}
}
