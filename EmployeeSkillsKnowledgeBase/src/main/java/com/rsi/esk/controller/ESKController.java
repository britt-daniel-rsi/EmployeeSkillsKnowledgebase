package com.rsi.esk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ESKController {

	@RequestMapping("/")
	public String viewApplication() {
		return "index";
	}
}
