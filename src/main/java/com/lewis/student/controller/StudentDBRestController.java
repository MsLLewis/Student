package com.lewis.student.controller;

import com.lewis.student.model.Student;
import com.lewis.student.service.StudentDBService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
public class StudentDBRestController {

    Logger logger = LoggerFactory.getLogger(StudentDBRestController.class);

    @Autowired
    StudentDBService studentDBService;

    @GetMapping("/all-students")
    public List<Student> getAllStudents(){
        List<Student> students = studentDBService.findAllStudents();
        return students;
    }

    @PostMapping("/addstudent")
    public void addStudent(@RequestBody Student student){
        studentDBService.save(student);
    }

    @GetMapping("/students/{id}")
    public Optional<Student> findStudentById(@PathVariable Long id){
        Optional<Student> student = studentDBService.findStudentById(id);

        return student;
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable("id") Long id){
        studentDBService.deleteStudent(id);

    }
    @RequestMapping("/checklogs")
    public String demoLogs() {
        logger.trace("This is a trace log example");
        logger.info("This is an info log example");
        logger.debug("This is a debug log example");
        logger.error("This is an error log example");
        logger.warn("This is a warn log example");
        return "Howdy! Check out the Logs to see the output...";
    }

    @GetMapping("/slf4j-log")
    public String runSlf4jLogs() {
        log.warn("enter hello...");
        log.info("Simple log statement with inputs {}, {} and {}", 1, 2, 3);
        log.trace("This is a trace log example");
        log.debug("This is a debug log example");
        log.error("This is an error log example");
        log.warn("This is a warn log example");
        return "hello rest";
    }

}
