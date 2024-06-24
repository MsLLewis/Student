package com.lewis.student.controller;

import com.lewis.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class StudentController {

    private final ArrayList<Student> students;


    @Autowired
    public StudentController(ArrayList<Student> students){
        this.students = students;
    }


    @GetMapping("/student")   //endpoint
    public String showForm(Model model){
        model.addAttribute("student", new Student());
        return "student";
    }

    @PostMapping("/student") //endpoint
    public String submitForm(@ModelAttribute Student student, Model model){
        model.addAttribute("student", student);
        return "result";
    }

    @GetMapping("/listStudents")  //endpoint
    public String listStudent(Model model){
        model.addAttribute("students", students);
        return "list-students";
    }
}
