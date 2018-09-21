package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name",name);
		return "challenge";
	}
	
	@RequestMapping("/challenge/{name}")
	public String challengePath(@PathVariable String name, Model model) {
		model.addAttribute("name", name);
		return "challenge";
	}
	
	@RequestMapping("/generator")
	public String generator(@RequestParam(value = "a", required = false, defaultValue = "0") String aValue,
			@RequestParam(value = "b", required = false, defaultValue = "0") String bValue, Model model) {
		int intAValue = Integer.parseInt(aValue);
		int intBValue = Integer.parseInt(bValue);
		
		String res = "h";
		
		if (intAValue < 2) {
			intAValue = 1;
		} if (intBValue < 2) {
			intBValue = 1;
		}
		
		for (int i = 0; i < intAValue; i++) {
			res += "m";
		}
		
		String duplicateRes = res;
		for (int i = 0; i < intBValue; i++) {
			res += " " + duplicateRes;
		}
		
		model.addAttribute("aValue", intAValue);
		model.addAttribute("bValue", intBValue);
		model.addAttribute("result", res);
		return "generator";
	}
}