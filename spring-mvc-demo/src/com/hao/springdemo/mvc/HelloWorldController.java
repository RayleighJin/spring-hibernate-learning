package com.hao.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	// need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processFormV2")
	public String readFormAdd2Model(HttpServletRequest req, Model model) {
		String name = req.getParameter("studentName").toUpperCase();
		String result = "YOOOOO! " + name + "!";
		
		model.addAttribute("message", result);
		
		return "helloworld";
	}
}
