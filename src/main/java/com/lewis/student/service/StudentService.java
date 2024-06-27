package com.lewis.student.service;

import com.lewis.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {


    private final List<Student>students;

    @Autowired
    public StudentService(List<Student> students){
        this.students = students;
    }

    public List<Student> getStudents(){
        return  students;
    }

    public Student getStudentByRollNumber(String rollNumber){
        for(Student student: students){
            if(student.getRollNumber().equals(rollNumber)){
                return student;
            }
        }
        return null;
    }


}
