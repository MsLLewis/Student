package com.lewis.student.controller;

import com.lewis.student.model.Student;
import com.lewis.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/my-api")
public class StudentRestController{

    private final ArrayList<Student> students;
    private final StudentService studentService;

    @Autowired
    public StudentRestController(ArrayList<Student> students, StudentService studentService) {
        this.students = students;
        this.studentService = studentService;
    }

    @GetMapping("/getStudents")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/{rollNumber}")
    public Student  getStudentByRollNumber(@PathVariable String rollNumber){
        return studentService.getStudentByRollNumber(rollNumber);
    }

    @GetMapping("/all-students")
    public List<Student> retrieveAllStudents(){
        return Arrays.asList(
                new Student("Lisa", "0010", "F"),
                new Student("Mary","001", "F")
        );
    }

}
