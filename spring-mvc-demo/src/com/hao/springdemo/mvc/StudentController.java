package com.hao.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	// add data to the model
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		// create a student object
		Student student = new Student();
		
		// add student object to the model
		model.addAttribute("student", student);
		
		return "student-form";
	}
	
	// retrieve data from the model
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student) {
		System.out.println(student.getFirstName() + " " + student.getLastName());
		return "student-confirmation";
	}
}
