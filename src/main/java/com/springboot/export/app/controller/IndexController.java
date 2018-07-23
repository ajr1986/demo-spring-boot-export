package com.springboot.export.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.export.app.model.service.AppService;

@Controller
public class IndexController {

	@Autowired
	private AppService appService;

	@GetMapping(value = { "/", "/index" })
	public String index(Model model) {

		model.addAttribute("title", "Export App Demo");
		model.addAttribute("apps", appService.getApps());

		return "index";
	}
}
