package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;
    @Value("${favoriteLanguages}")
    private List<String> favoriteLanguages;

    @Value("${systems}")
    private List<String> systems;

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel) {

        Student theStudent = new Student();

        theModel.addAttribute("student", theStudent);

        theModel.addAttribute("countries", countries);

        theModel.addAttribute("favoriteLanguages", favoriteLanguages);

        theModel.addAttribute("systems", systems);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {

        System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());

        return "student-confirmation";

    }
}
