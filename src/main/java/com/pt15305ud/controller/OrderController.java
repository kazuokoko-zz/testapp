package com.pt15305ud.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pt15305ud.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService _oSer;

	@RequestMapping("/checkout")
	public String checkout() {
		return "order/checkout";
	}

	@RequestMapping("/list")
	public String list(Model model, HttpServletRequest req) {
		String username = req.getRemoteUser();
		model.addAttribute("orders", _oSer.findByUsername(username));
		return "order/list";
	}

	@RequestMapping("/detail/{id}")
	public String detail(@PathVariable("id") Long id, Model model) {
		model.addAttribute("order", _oSer.findById(id));
		return "order/detail";
	}

}
