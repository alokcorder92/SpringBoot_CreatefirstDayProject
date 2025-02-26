package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Student;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@GetMapping("/register")
	public String showregisterPage(Model model) {
		Student student= new Student();
		model.addAttribute("student",student);
		
		model.addAttribute("message","reg form is sucess sumitted");
		
		return "register";
	}
	@PostMapping("/create")
	public String register(@Valid @ModelAttribute Student student,BindingResult bindingresult) {
		if(bindingresult.hasErrors()) {
			return "register";
		}
		System.out.println("Name = "+student.getName());
		System.out.println("Email = "+student.getEmail());
		System.out.println("Phno = "+student.getPhno());
		System.out.println("Address = "+student.getAddress());
		return "register";
	}
}

