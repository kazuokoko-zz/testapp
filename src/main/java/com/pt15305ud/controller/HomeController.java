package com.pt15305ud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping({ "/", "/home", "/home/index" })
	public String home() {
		return "redirect:/product/list";
	}

	@RequestMapping({ "/admin", "admin/home", "/admin/home/index" })
	public String admin() {
		return "redirect:/assets/admin/index.html#!/product";
	}

}
