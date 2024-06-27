package com.lewis.student.service;

import com.lewis.student.respository.StudentRepository;
import com.lewis.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentDBService {


    StudentRepository studentRepository;

//    //Constructor DI
    @Autowired
    public StudentDBService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }


    public List<Student> findAllStudents(){
        List<Student> students = studentRepository.findAll();
        return students;
    }

    public Optional<Student> findStudentById(Long id){
        return studentRepository.findById(id);
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

    public void save(Student student){
        studentRepository.save(student);
    }
}
