package com.lewis.student.controller;

import com.lewis.student.model.Student;
import com.lewis.student.service.StudentDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students") //controller endpoint
public class StudentSecurityController {

    @Autowired
    private StudentDBService studentDBService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login(){
        return "students/login";
    }

    @GetMapping("/all")
    public String getAllStudents(Model model){
        List<Student> students = studentDBService.findAllStudents();
        model.addAttribute("students", students);
        return "students/list";
    }

    @GetMapping("/{id}")
    public String findStudentById(@PathVariable Long id, Model model){
        Optional<Student> student = studentDBService.findStudentById(id);
        if(student.isPresent()){
            model.addAttribute("student", student.get());
            return "students/view";
        }else{
            return "students/not-found";
        }
    }

    @GetMapping("/create-student")
    public String showCreateForm(Model model){
        model.addAttribute("student", new Student());
        return "students/create";
    }

    @PostMapping("/create-student")
        public String addStudent(@ModelAttribute Student student){
            String encodedPassword = passwordEncoder.encode(student.getPassword());
            student.setPassword(encodedPassword);
            studentDBService.save(student);
            return "redirect:/students/all";  //redirecting to the 'all' endpoint

    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        studentDBService.deleteStudent(id);
        return "redirect:/students/all";
    }
}
