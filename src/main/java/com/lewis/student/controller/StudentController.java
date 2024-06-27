package com.lewis.student.controller;

import com.lewis.student.model.Student;
import com.lewis.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@SessionAttributes("student")
public class StudentController {

    private final ArrayList<Student> students;

    private final StudentService studentService;


  /*
  Constructor DI - Spring Container is injecting StudentService and students into the StudentController
   */
   @Autowired
    public StudentController(ArrayList<Student> students, StudentService studentService){
        this.students = students;
        this.studentService = studentService;
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

    @GetMapping("/listAllStudents")
  public String listAllStudents(Model model){
       model.addAttribute("students", studentService.getStudents());
       return "list-students";
  }

  /*
    Use RequestMapping to define multiple endpoints and specify the request type GET
   */
    @RequestMapping(value = {"/view", "/display"}, method = RequestMethod.GET )
    public String viewStudents(Model model){
       model.addAttribute("students", studentService.getStudents());
       return "list-students";
    }

    /*
       Utilizing the @PathVariable annotation to extract values from the URI path and bind them to method params.
     */
    @GetMapping("/view/{rollNumber}")
      public String viewStudent( @PathVariable String rollNumber, Model model){
        Student student = studentService.getStudentByRollNumber(rollNumber);
        model.addAttribute("student", student);
        return "result";

      }

    @PostMapping("/submitStudent")
      public String submitFormWithParams(@RequestParam("name") String name, @RequestParam("rollNumber") String rollNumber,
                                         @ModelAttribute("student")Student student){
        student.setName(name);
        student.setRollNumber(rollNumber);
        return "result";

      }




}
