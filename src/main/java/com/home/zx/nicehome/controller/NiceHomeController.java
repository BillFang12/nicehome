package com.home.zx.nicehome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NiceHomeController {

	@RequestMapping("/home")
	public String home(ModelMap map){
		return "index";
	}
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
}
