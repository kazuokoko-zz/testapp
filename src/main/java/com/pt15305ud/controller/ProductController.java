package com.pt15305ud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pt15305ud.entity.Product;
import com.pt15305ud.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService pSer;

	@RequestMapping("/list")
	public String list(Model model, @RequestParam("cid") Optional<String> cid) {
		List<Product> list;
		if (cid.isPresent()) {
			list = pSer.findByCategoryIdAndAvailable(cid.get());
		} else {
			list = pSer.findAllAndAvailable();
		}
		model.addAttribute("items", list);
		return "product/list";
	}

	@RequestMapping("/detail/{id}")
	public String detail(@PathVariable Integer id, Model model) {
		Product product = pSer.findById(id);
		model.addAttribute("item", product);
		return "product/detail";
	}

}
